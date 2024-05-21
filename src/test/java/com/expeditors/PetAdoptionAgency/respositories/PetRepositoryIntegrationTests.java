package com.expeditors.PetAdoptionAgency.respositories;

import com.expeditors.PetAdoptionAgency.dao.JpaTestDataUtil;

import com.expeditors.PetAdoptionAgency.domain.JpaAdopter;
import com.expeditors.PetAdoptionAgency.domain.JpaPet;
import com.expeditors.PetAdoptionAgency.domain.Pet;
import com.expeditors.PetAdoptionAgency.repositories.PetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("jpa-dev")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PetRepositoryIntegrationTests {

    private PetRepository petRepository;

    @Autowired
    public PetRepositoryIntegrationTests(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    @Test
    public void TestThatPetCanBeCreatedAndRecalled(){
        JpaAdopter adopter = JpaTestDataUtil.createTestJpaAdopter();
        JpaPet pet = JpaTestDataUtil.createTestJpaPet(adopter);
        petRepository.save(pet);
        Optional<JpaPet> result = petRepository.findById(pet.getId());
        assertThat(result).isPresent();
    }

//    @Test
//    public void TestThatPetWithAdopterCanBeCreatedAndRecalled(){
////        Adopter adopter = TestDataUtil.createTestAdopter();
////        adopterDAO.create(adopter);
//        Pet pet = TestDataUtil.createTestPet();
//        pet.setAdopterId(1);
//        jdbcTPetDAO.create(pet);
//        Optional<Pet> result = jdbcTPetDAO.findByAdopterId(pet.getAdopterId());
//        assertThat(result).isPresent();
//    }
//
    @Test
    public void testThatMultiplePetsCanBeCreatedAndRecalled(){
        JpaAdopter adopter = JpaTestDataUtil.createTestJpaAdopter();

        JpaPet petA = JpaTestDataUtil.createTestJpaPet(adopter);
        petRepository.save(petA);

        JpaPet petB = JpaTestDataUtil.createTestJpaPetB(adopter);
        petRepository.save(petB);

        JpaPet petC = JpaTestDataUtil.createTestJpaPetC(adopter);
        petRepository.save(petC);

        Iterable<JpaPet> result = petRepository.findAll();
        assertThat(result).hasSizeGreaterThanOrEqualTo(3);
    }

    @Test
    public void testThatPetCanBeUpdated(){
        JpaAdopter adopter = JpaTestDataUtil.createTestJpaAdopter();

        JpaPet petA = JpaTestDataUtil.createTestJpaPet(adopter);
        petRepository.save(petA);

        petA.setName("UPDATED");
        petRepository.save(petA);

        Optional<JpaPet> result = petRepository.findById(petA.getId());
        assertThat(result).isPresent();
    }

    @Test
    public void testThatPetCanBeDeleted(){
        JpaAdopter adopter = JpaTestDataUtil.createTestJpaAdopter();

        JpaPet petA = JpaTestDataUtil.createTestJpaPet(adopter);

        petRepository.save(petA);

        petRepository.deleteById(petA.getId());
        Optional<JpaPet> result = petRepository.findById(petA.getId());
        assertThat(result).isEmpty();
    }
    @Test
    public void testThatCanGetAllPetsWithAdopter(){
        JpaAdopter adopter = JpaTestDataUtil.createTestJpaAdopter();

        JpaPet petA = JpaTestDataUtil.createTestJpaPet(adopter);
        JpaPet petB = JpaTestDataUtil.createTestJpaPetWithoutAdopter();
        petRepository.save(petA);
        petRepository.save(petB);
        Iterable<JpaPet> result = petRepository.findAllPetsWithAdopters();

        assertThat(result).hasSizeGreaterThanOrEqualTo(1);

    }

    @Test
    public void testThatCanGetAllPetsWithoutAdopter(){
        JpaPet petB = JpaTestDataUtil.createTestJpaPetWithoutAdopter();
        petRepository.save(petB);

        Iterable<JpaPet> result = petRepository.findAllPetsWithoutAdopters();
        assertThat(result).hasSizeGreaterThanOrEqualTo(1);
    }
    @Test
    public void testCanFindAdopterByPetId(){
        JpaAdopter adopter = JpaTestDataUtil.createTestJpaAdopter();

        JpaPet petA = JpaTestDataUtil.createTestJpaPet(adopter);

        petRepository.save(petA);
        Iterable<JpaAdopter> result = petRepository.findAdopterByPetId(petA.getId());
        assertThat(result).hasSize(1);

    }
}
