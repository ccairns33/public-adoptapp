package com.expeditors.PetAdoptionAgency.dao;

import com.expeditors.PetAdoptionAgency.domain.JpaAdopter;
import com.expeditors.PetAdoptionAgency.domain.JpaPet;

import java.time.LocalDate;

public final class JpaTestDataUtil {
    private JpaTestDataUtil(){

    }

    public static JpaAdopter createTestJpaAdopter() {
        return JpaAdopter.builder()
                .id(1)
                .name("JPA-Devin")
                .phoneNumber("9999990000")
                .dateOfAdoption(LocalDate.of(2024,10,10))
                .build();
    }
    public static JpaAdopter createTestJpaAdopterB() {
        return JpaAdopter.builder()
                .id(2)
                .name("JPA-Derik")
                .phoneNumber("9999990000")
                .dateOfAdoption(LocalDate.of(2024,10,10))
                .build();
    }
    public static JpaAdopter createTestJpaAdopterC() {
        return JpaAdopter.builder()
                .id(3)
                .name("JPA-Dima")
                .phoneNumber("9999990000")
                .dateOfAdoption(LocalDate.of(2024,10,10))
                .build();
    }

    public static JpaPet createTestJpaPet(final JpaAdopter adopter){
        return JpaPet.builder()
                .name("Felicity")
                .type(JpaPet.PetType.DOG)
                .breed("Standard Poodle")
                .jpaAdopter(adopter)
                .build();
    }
    public static JpaPet createTestJpaPetB(final JpaAdopter adopter){
        return JpaPet.builder()
                .name("Monte")
                .type(JpaPet.PetType.DOG)
                .breed("Small Poodle")
                .jpaAdopter(adopter)
                .build();
    }
    public static JpaPet createTestJpaPetC(final JpaAdopter adopter){
        return JpaPet.builder()
                .name("Sheffie")
                .type(JpaPet.PetType.DOG)
                .breed("Russian Labrador")
                .jpaAdopter(adopter)
                .build();
    }
}
