package com.expeditors.PetAdoptionAgency.respositories;

import com.expeditors.PetAdoptionAgency.dao.JpaTestDataUtil;
import com.expeditors.PetAdoptionAgency.domain.JpaAdopter;
import com.expeditors.PetAdoptionAgency.repositories.AdopterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("jpa-dev")
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AdopterRepositoryIntegrationTests {


    private final AdopterRepository adopterRepository;

    @Autowired
    public AdopterRepositoryIntegrationTests(AdopterRepository adopterRepository) {
        this.adopterRepository = adopterRepository;
    }


    @Test
    public void testThatAdopterCanBeCreatedAndRecalled(){
        JpaAdopter adopter = JpaTestDataUtil.createTestJpaAdopter();
        adopterRepository.save(adopter);
        Optional<JpaAdopter> result = adopterRepository.findById(adopter.getId());
        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(adopter);

    }

    @Test
    public void TestThatMultipleAdoptersVanBeCreatedAndRecalled(){
        JpaAdopter adopterA = JpaTestDataUtil.createTestJpaAdopter();
        adopterRepository.save(adopterA);
        JpaAdopter adopterB = JpaTestDataUtil.createTestJpaAdopterB();
        adopterRepository.save(adopterB);
        JpaAdopter adopterC = JpaTestDataUtil.createTestJpaAdopterC();
        adopterRepository.save(adopterC);
        Iterable<JpaAdopter> result = adopterRepository.findAll();
        assertThat(result).hasSize(3);

    }

    @Test
    public void testThatAdopterCanBeUpdated(){
        JpaAdopter adopterA = JpaTestDataUtil.createTestJpaAdopter();
        adopterRepository.save(adopterA);
        adopterA.setName("UPDATED");
        adopterRepository.save(adopterA);
        Optional<JpaAdopter> result = adopterRepository.findById(adopterA.getId());
        assertThat(result).isPresent();


    }

    @Test
    public void testThatAdopterCanBeDeleted(){
        JpaAdopter adopterA = JpaTestDataUtil.createTestJpaAdopter();
        adopterRepository.save(adopterA);
        adopterRepository.deleteById(adopterA.getId());
        Optional<JpaAdopter> result = adopterRepository.findById(adopterA.getId());
        assertThat(result).isEmpty();
    }

    @Test
    public void testThatGetAdopterWithName(){
        JpaAdopter adopter = JpaTestDataUtil.createTestJpaAdopter();
        adopterRepository.save(adopter);
        Optional<JpaAdopter> result = adopterRepository.findByName(adopter.getName());
        assertThat(result).isPresent();
    }

    @Test
    public void testThatGetAdoptersWithDateOfAdoption(){
        JpaAdopter adopter = JpaTestDataUtil.createTestJpaAdopter();
        adopterRepository.save(adopter);
        Iterable<JpaAdopter> result = adopterRepository.findAllWithDateOfAdoption();
        assertThat(result).hasSizeGreaterThanOrEqualTo(1);
    }

}
