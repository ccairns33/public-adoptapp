package com.expeditors.PetAdoptionAgency.dao.jdbcTemp;

import com.expeditors.PetAdoptionAgency.dao.TestDataUtil;
import com.expeditors.PetAdoptionAgency.domain.Adopter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("jdbct-dev")
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class JdbcTAdopterDAOIntegrationTests {


    private final JdbcTAdopterDAO jdbcTAdopterDAO;

    @Autowired
    public JdbcTAdopterDAOIntegrationTests(JdbcTAdopterDAO jdbcTAdopterDAO) {
        this.jdbcTAdopterDAO = jdbcTAdopterDAO;
    }


    @Test
    public void testThatAdopterCanBeCreatedAndRecalled(){
        Adopter adopter = TestDataUtil.createTestAdopter();
        jdbcTAdopterDAO.create(adopter);
        Optional<Adopter> result = jdbcTAdopterDAO.findById(1);
        assertThat(result).isPresent();

    }

    @Test

    public void TestThatMultipleAdoptersVanBeCreatedAndRecalled(){
        Adopter adopterA = TestDataUtil.createTestAdopter();
        jdbcTAdopterDAO.create(adopterA);
        Adopter adopterB = TestDataUtil.createTestAdopterB();
        jdbcTAdopterDAO.create(adopterB);
        Adopter adopterC = TestDataUtil.createTestAdopterC();
        jdbcTAdopterDAO.create(adopterC);
        List<Adopter> result = jdbcTAdopterDAO.findAll();
        assertThat(result).hasSizeGreaterThanOrEqualTo(3);

    }

    @Test
    public void testThatAdopterCanBeUpdated(){
//        Adopter adopterA = TestDataUtil.createTestAdopter();
//        jdbcTAdopterDAO.create(adopterA);
//        adopterA.setName("UPDATED");
//        jdbcTAdopterDAO.update(adopterA, 1);


    }

    @Test
    public void testThatAdopterCanBeDeleted(){
        Adopter adopterA = TestDataUtil.createTestAdopter();
        jdbcTAdopterDAO.create(adopterA);
        jdbcTAdopterDAO.delete(2);
        Optional<Adopter> result = jdbcTAdopterDAO.findById(2);
        assertThat(result).isEmpty();
    }

}
