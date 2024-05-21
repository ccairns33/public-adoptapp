package com.expeditors.PetAdoptionAgency.service;

import com.expeditors.PetAdoptionAgency.dao.AdopterDAO;
import com.expeditors.PetAdoptionAgency.domain.Adopter;
import com.expeditors.PetAdoptionAgency.domain.Pet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Profile({"jdbct-dev", "inmem-dev"})
public class AdopterService {

    private final AdopterDAO adopterDAO;

    public AdopterService(AdopterDAO adopterDAO) {
        this.adopterDAO = adopterDAO;
    }

    public Adopter addAdopter(Adopter adopter) {
        return adopterDAO.insert(adopter);
    }

    public List<Adopter> getAllAdopters() {
        return adopterDAO.findAll();
    }

    public Optional<Adopter> findById(Integer id) {
        return adopterDAO.findById(id);
    }

    public void create(Adopter adopter) {
        adopterDAO.create(adopter);
    }

    public void update(Adopter adopter, Integer id) {
        adopterDAO.update(adopter, id);
    }

    public void delete(Integer id) {
        adopterDAO.delete(id);
    }

    public List<Pet> getAllAdopterPets(Integer id) {
        return adopterDAO.getAllAdopterPets(id);
    }
}
