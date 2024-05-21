package com.expeditors.PetAdoptionAgency.dao.jdbcTemp;

import com.expeditors.PetAdoptionAgency.dao.TestDataUtil;
import com.expeditors.PetAdoptionAgency.domain.Adopter;
import com.expeditors.PetAdoptionAgency.domain.Pet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
@ActiveProfiles("jdbct-dev")
class JdbcTPetDAOTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private JdbcTPetDAO jdbcTPetDAO;

    @Test
    public void testThatCreatePetGeneratesCorrectSql(){
        Pet pet = TestDataUtil.createTestPet();

        jdbcTPetDAO.create(pet);

        verify(jdbcTemplate).update(
                "INSERT INTO pets (name, petType, breed) VALUES (?,?,?)",
                "Felicity","DOG", "Standard Poodle"
                );


    }


    @Test
    public void testThatPetFindByIdGeneratesCorrectSql(){
        jdbcTPetDAO.findById(1);
        verify(jdbcTemplate).query(
                eq("SELECT id, name, pet_type, breed FROM pets WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<JdbcTPetDAO.PetRowMapper>any(),
                eq(1)
        );
    }

    @Test
    public void testThatFindGeneratesCorrectSql(){
        jdbcTPetDAO.findAll();
        verify(jdbcTemplate).query(
                eq("SELECT id, name, pet_type, breed FROM pets"),
                ArgumentMatchers.<JdbcTPetDAO.PetRowMapper>any()
        );
    }

    @Test
    public void testThatDeleteGeneratesCorrectSql(){
        jdbcTPetDAO.delete(2);
        verify(jdbcTemplate).update(
                "DELETE FROM pets WHERE id = ?",
                2
        );
    }

}