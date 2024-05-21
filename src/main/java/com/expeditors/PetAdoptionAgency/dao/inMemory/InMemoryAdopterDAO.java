package com.expeditors.PetAdoptionAgency.dao.inMemory;

import com.expeditors.PetAdoptionAgency.dao.AdopterDAO;
import com.expeditors.PetAdoptionAgency.domain.Adopter;
import com.expeditors.PetAdoptionAgency.domain.Pet;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Profile("inmem-dev")
@Repository
public class InMemoryAdopterDAO implements AdopterDAO {

    private Map<Integer, Adopter> adopters = new ConcurrentHashMap<>();
    private AtomicInteger nextId = new AtomicInteger(1);

    public Adopter insert(Adopter newAdopter) {
        newAdopter.setId(nextId.getAndIncrement());
        newAdopter.setName("InMem: " + newAdopter.getName());
        adopters.put(newAdopter.getId(), newAdopter);

        return newAdopter;
    }

    public boolean delete(int id) {
        return adopters.remove(id) != null;
    }

    public boolean update(Adopter adopter, Integer id) {
        return adopters.replace(id, adopter) != null;
    }

    public Optional<Adopter> findById(int id) {
        return Optional.ofNullable(adopters.get(id));
    }

    public List<Adopter> findAll() {
        return new ArrayList(adopters.values());
    }

    public void create(Adopter adopter) {
        Adopter newAdopter = new Adopter(
                adopter.getName(),
                adopter.getPhoneNumber(),
                adopter.getdateOfAdoption(),
                adopter.getPet()
        );
        insert(newAdopter);
    }


    public List<Pet> getAllAdopterPets(Integer id) {
        Adopter adopter = adopters.get(id);
        System.out.println(adopter.getPet());
        return adopter.getPet();
    }


}
