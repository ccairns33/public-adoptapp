package com.expeditors.PetAdoptionAgency.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Pet {



    public enum PetType {
        CAT,
        DOG,
        TURTLE
    }

    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private PetType type;
    @NonNull
    private String breed;

    private Integer adopterId;




    private static final AtomicInteger counter = new AtomicInteger(1);
    public Pet() {
    }

    public Pet(int id, @NonNull PetType type, @NonNull String name, @NonNull String breed) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.breed = breed;
    }

    public Pet(@NonNull PetType type, @NonNull String name, @NonNull String breed) {
        this.id = counter.getAndIncrement();
        this.type = type;
        this.name = name;
        this.breed = breed;
    }

    public int getId() {
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

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getPetId() {
        return id;
    }

    public void setPetId(Integer id) {
        this.id = id;
    }

    public Integer getAdopterId() {
        return adopterId;
    }

    public void setAdopterId(Integer adopterId) {
        this.adopterId = adopterId;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", breed='" + breed + '\'' +
                ", adopterId=" + adopterId +
                '}';
    }
}
