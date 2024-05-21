package com.expeditors.PetAdoptionAgency.dao.jdbcTemp;

import com.expeditors.PetAdoptionAgency.dao.AdopterDAO;
import com.expeditors.PetAdoptionAgency.dao.TestDataUtil;
import com.expeditors.PetAdoptionAgency.domain.Adopter;
import com.expeditors.PetAdoptionAgency.domain.Pet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("jdbct-dev")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class JdbcTPetDAOIntegrationTests {

    private AdopterDAO adopterDAO;
    private JdbcTPetDAO jdbcTPetDAO;

    @Autowired
    public JdbcTPetDAOIntegrationTests(AdopterDAO adopterDAO, JdbcTPetDAO jdbcTPetDAO) {
        this.adopterDAO = adopterDAO;
        this.jdbcTPetDAO = jdbcTPetDAO;
    }


    @Test
    public void TestThatPetCanBeCreatedAndRecalled(){
        Pet pet = TestDataUtil.createTestPet();
        jdbcTPetDAO.create(pet);
        Optional<Pet> result = jdbcTPetDAO.findByName(pet.getName());
        assertThat(result).isPresent();
    }

    @Test
    public void TestThatPetWithAdopterCanBeCreatedAndRecalled(){
//        Adopter adopter = TestDataUtil.createTestAdopter();
//        adopterDAO.create(adopter);
        Pet pet = TestDataUtil.createTestPet();
        pet.setAdopterId(1);
        jdbcTPetDAO.create(pet);
        Optional<Pet> result = jdbcTPetDAO.findByAdopterId(pet.getAdopterId());
        assertThat(result).isPresent();
    }

    @Test
    public void testThatMultiplePetsCanBeCreatedAndRecalled(){
        //        Adopter adopter = TestDataUtil.createTestAdopter();
        //        adopterDAO.create(adopter);


        Pet petA = TestDataUtil.createTestPet();
        petA.setAdopterId(1);
        jdbcTPetDAO.create(petA);

        Pet petB = TestDataUtil.createTestPetB();
        petA.setAdopterId(1);
        jdbcTPetDAO.create(petB);

        Pet petC = TestDataUtil.createTestPetC();
        petA.setAdopterId(1);
        jdbcTPetDAO.create(petC);

        List<Pet> result = jdbcTPetDAO.findAll();
        Assertions.assertThat(result).hasSizeGreaterThanOrEqualTo(3);
    }

    @Test
    public void testThatPetCanBeUpdated(){
        Adopter adopter = TestDataUtil.createTestAdopter();
        adopterDAO.create(adopter);

        Pet petA = TestDataUtil.createTestPet();
        petA.setAdopterId(1);
        jdbcTPetDAO.create(petA);

        Pet petToId = jdbcTPetDAO.findByName(petA.getName()).get();
        petA.setName("UPDATED");
        petA.setPetId(petToId.getPetId());
        jdbcTPetDAO.update(petA, petToId.getPetId());

        jdbcTPetDAO.findById(petA.getPetId());
    }

    @Test
    public void testThatPetCanBeDeleted(){
        Adopter adopter = TestDataUtil.createTestAdopter();
        adopterDAO.create(adopter);

        Pet petA = TestDataUtil.createTestPet();
        petA.setAdopterId(1);
        Pet petToId = jdbcTPetDAO.findByName(petA.getName()).get();
        petA.setPetId(petToId.getPetId());
        jdbcTPetDAO.create(petA);

        jdbcTPetDAO.delete(petA.getId());
        Optional<Pet> result = jdbcTPetDAO.findById(petA.getId());
        assertThat(result).isEmpty();
    }
}
