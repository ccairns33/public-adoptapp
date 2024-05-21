package com.expeditors.PetAdoptionAgency.domain;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Adopter {
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String phoneNumber;
    @NonNull
    private LocalDate dateOfAdoption;

    private List<Pet> pet;

    private Integer petId;


    public Adopter(@NonNull String name, @NonNull String phoneNumber, @NonNull LocalDate dateOfAdoption, List<Pet> pet) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateOfAdoption = dateOfAdoption;
        this.pet = new ArrayList<>(pet);
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getdateOfAdoption() {
        return dateOfAdoption;
    }

    public void setdateOfAdoption(LocalDate dateOfAdoption) {
        this.dateOfAdoption = dateOfAdoption;
    }


    public List<Pet> getPet() {
        return pet;
    }

    public void setPet(List<Pet> pet) {
        this.pet = pet;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    @Override
    public String toString() {
        return "Adopter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfAdoption=" + dateOfAdoption +
                ", pet=" + pet +
                '}';
    }
}
