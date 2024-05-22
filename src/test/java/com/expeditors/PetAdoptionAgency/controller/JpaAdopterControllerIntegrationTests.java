package com.expeditors.PetAdoptionAgency.controller;

import com.expeditors.PetAdoptionAgency.dao.JpaTestDataUtil;
import com.expeditors.PetAdoptionAgency.domain.JpaAdopter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc // configures mockMvc for us
public class JpaAdopterControllerIntegrationTests {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @Autowired
    public JpaAdopterControllerIntegrationTests(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

    @Test
    public void testThatCreateAdopterSuccessfullyReturnsHTTPCreated() throws Exception {
        JpaAdopter jpaAdopter = JpaTestDataUtil.createTestJpaAdopter();
        jpaAdopter.setId(null);
        String adopterJSON = objectMapper.writeValueAsString(jpaAdopter);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/adopters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(adopterJSON)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );

    }
}
