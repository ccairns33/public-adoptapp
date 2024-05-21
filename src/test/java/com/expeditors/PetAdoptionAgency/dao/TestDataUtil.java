package com.expeditors.PetAdoptionAgency.dao;

import com.expeditors.PetAdoptionAgency.domain.Adopter;
import com.expeditors.PetAdoptionAgency.domain.Pet;

import java.time.LocalDate;

public final class TestDataUtil {
    private TestDataUtil(){

    }

    public static Adopter createTestAdopter() {
        return Adopter.builder()
                .id(9999)
                .name("H2-Devin")
                .phoneNumber("9999990000")
                .dateOfAdoption(LocalDate.of(2024,10,10))
                .build();
    }
    public static Adopter createTestAdopterB() {
        return Adopter.builder()
                .id(10000)
                .name("H2-Derik")
                .phoneNumber("9999990000")
                .dateOfAdoption(LocalDate.of(2024,10,10))
                .build();
    }
    public static Adopter createTestAdopterC() {
        return Adopter.builder()
                .id(10001)
                .name("H2-Dima")
                .phoneNumber("9999990000")
                .dateOfAdoption(LocalDate.of(2024,10,10))
                .build();
    }

    public static Pet createTestPet(){
        return Pet.builder()
                .name("Felicity")
                .type(Pet.PetType.DOG)
                .breed("Standard Poodle")
                .build();
    }
    public static Pet createTestPetB(){
        return Pet.builder()
                .name("Monte")
                .type(Pet.PetType.DOG)
                .breed("Small Poodle")
                .build();
    }
    public static Pet createTestPetC(){
        return Pet.builder()
                .name("Sheffie")
                .type(Pet.PetType.DOG)
                .breed("Russian Labrador")
                .build();
    }
}
