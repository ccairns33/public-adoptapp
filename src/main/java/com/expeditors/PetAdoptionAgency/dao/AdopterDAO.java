package com.expeditors.PetAdoptionAgency.dao;

import com.expeditors.PetAdoptionAgency.domain.Adopter;
import com.expeditors.PetAdoptionAgency.domain.Pet;

import java.util.List;
import java.util.Optional;

public interface AdopterDAO {
    Adopter insert(Adopter newAdopter);

    boolean delete(int id);

    boolean update(Adopter adopter, Integer id);

    Optional<Adopter> findById(int id);

    List<Adopter> findAll();

    void create(Adopter adopter);

    List<Pet> getAllAdopterPets(Integer id);

}
