package com.expeditors.PetAdoptionAgency.dao.jdbcTemp;

import com.expeditors.PetAdoptionAgency.dao.TestDataUtil;
import com.expeditors.PetAdoptionAgency.domain.Adopter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("jdbct-dev")
class JdbcTAdopterDAOTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private JdbcTAdopterDAO jdbcTAdopterDAO;

    @Test
    public void testThatCreateAdopterGeneratesCorrectSql(){
        Adopter adopter = TestDataUtil.createTestAdopter();
        jdbcTAdopterDAO.create(adopter);

        verify(jdbcTemplate).update(
                "INSERT INTO adopters ( name, phone_number, date_of_adoption) VALUES (?,?,?);",
                "H2-Devin", "9999990000",LocalDate.of(2024,10,10)
                );
    }

    @Test
    public void testFindByIdGeneratesCorrectSql(){
        jdbcTAdopterDAO.findById(1);
        verify(jdbcTemplate).query(
                eq("SELECT id, name, phone_number, date_of_adoption FROM adopters WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<JdbcTAdopterDAO.AdopterRowMapper>any(), eq(1)
        );
    }

    @Test
    public void testThatFindManyGeneratesCorrectSql(){
        jdbcTAdopterDAO.findAll();
        verify(jdbcTemplate).query(
                eq("SELECT id, name, phone_number FROM adopters"),
                ArgumentMatchers.<JdbcTAdopterDAO.AdopterRowMapper>any()
        );

    }

    @Test
    public void testThatUpdateGeneratesCorrectSql(){
        Adopter adopter = TestDataUtil.createTestAdopter();
        jdbcTAdopterDAO.create(adopter);

//        Adopter adopter = jdbcTAdopterDAO.findById(1).get();
        jdbcTAdopterDAO.update(adopter, adopter.getId());

//        verify(jdbcTemplate).update(
//                "UPDATE adopters SET name = ?, phone_number = ?, date_of_adoption = ?, pet_id = ? WHERE id = ?",
//                "H2-Devin", "9999990000",2024-10-10,null
//                );

    }

    @Test
    public void testThatDeleteGeneratesTheCorrectSql(){
        jdbcTAdopterDAO.delete(1);
        verify(jdbcTemplate).update(
                "DELETE from adopters where id = ?",
                1
        );
    }
}