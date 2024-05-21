package com.expeditors.PetAdoptionAgency.dao;

import com.expeditors.PetAdoptionAgency.domain.Pet;
import com.expeditors.PetAdoptionAgency.domain.Pet;

import java.util.List;
import java.util.Optional;

public interface PetDAO {
    Pet insert(Pet newPet);

    boolean delete(int id);

    boolean update(Pet pet, Integer id);

    Optional<Pet> findById(int id);

    List<Pet> findAll();

    void create(Pet pet);

    List<Pet> getAllPets(Integer id);

    Optional<Pet> findByName(String name);

    Optional<Pet> findByAdopterId(Integer adopterId);
}
