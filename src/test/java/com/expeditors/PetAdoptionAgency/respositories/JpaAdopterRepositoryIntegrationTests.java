package com.expeditors.PetAdoptionAgency.respositories;

import com.expeditors.PetAdoptionAgency.dao.JpaTestDataUtil;
import com.expeditors.PetAdoptionAgency.domain.JpaAdopter;
import com.expeditors.PetAdoptionAgency.repositories.JpaAdopterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("jpa-dev")
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class JpaAdopterRepositoryIntegrationTests {


    private final JpaAdopterRepository jpaAdopterRepository;

    @Autowired
    public JpaAdopterRepositoryIntegrationTests(JpaAdopterRepository jpaAdopterRepository) {
        this.jpaAdopterRepository = jpaAdopterRepository;
    }


    @Test
    public void testThatAdopterCanBeCreatedAndRecalled(){
        JpaAdopter adopter = JpaTestDataUtil.createTestJpaAdopter();
        jpaAdopterRepository.save(adopter);
        Optional<JpaAdopter> result = jpaAdopterRepository.findById(adopter.getId());
        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(adopter);

    }

    @Test
    public void TestThatMultipleAdoptersVanBeCreatedAndRecalled(){
        JpaAdopter adopterA = JpaTestDataUtil.createTestJpaAdopter();
        jpaAdopterRepository.save(adopterA);
        JpaAdopter adopterB = JpaTestDataUtil.createTestJpaAdopterB();
        jpaAdopterRepository.save(adopterB);
        JpaAdopter adopterC = JpaTestDataUtil.createTestJpaAdopterC();
        jpaAdopterRepository.save(adopterC);
        Iterable<JpaAdopter> result = jpaAdopterRepository.findAll();
        assertThat(result).hasSize(3);

    }

    @Test
    public void testThatAdopterCanBeUpdated(){
        JpaAdopter adopterA = JpaTestDataUtil.createTestJpaAdopter();
        jpaAdopterRepository.save(adopterA);
        adopterA.setName("UPDATED");
        jpaAdopterRepository.save(adopterA);
        Optional<JpaAdopter> result = jpaAdopterRepository.findById(adopterA.getId());
        assertThat(result).isPresent();


    }

    @Test
    public void testThatAdopterCanBeDeleted(){
        JpaAdopter adopterA = JpaTestDataUtil.createTestJpaAdopter();
        jpaAdopterRepository.save(adopterA);
        jpaAdopterRepository.deleteById(adopterA.getId());
        Optional<JpaAdopter> result = jpaAdopterRepository.findById(adopterA.getId());
        assertThat(result).isEmpty();
    }

    @Test
    public void testThatGetAdopterWithName(){
        JpaAdopter adopter = JpaTestDataUtil.createTestJpaAdopter();
        jpaAdopterRepository.save(adopter);
        Optional<JpaAdopter> result = jpaAdopterRepository.findByName(adopter.getName());
        assertThat(result).isPresent();
    }

    @Test
    public void testThatGetAdoptersWithDateOfAdoption(){
        JpaAdopter adopter = JpaTestDataUtil.createTestJpaAdopter();
        jpaAdopterRepository.save(adopter);
        Iterable<JpaAdopter> result = jpaAdopterRepository.findAllWithDateOfAdoption();
        assertThat(result).hasSizeGreaterThanOrEqualTo(1);
    }

}
