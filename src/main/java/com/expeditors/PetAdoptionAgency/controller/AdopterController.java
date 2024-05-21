package com.expeditors.PetAdoptionAgency.controller;

import com.expeditors.PetAdoptionAgency.domain.Adopter;
import com.expeditors.PetAdoptionAgency.domain.Pet;
import com.expeditors.PetAdoptionAgency.service.AdopterService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Profile({"inmem-dev", "jdbct-dev"})
@RestController
@RequestMapping("/api/adopters")
public class AdopterController {

    private final AdopterService adopterService;


    public AdopterController(AdopterService adopterService) {
        this.adopterService = adopterService;
    }

    @GetMapping
    List<Adopter> findAll(){
        return adopterService.getAllAdopters();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/{id}")
    Adopter findById(@PathVariable Integer id){
        Optional<Adopter> adopter = adopterService.findById(id);
        if (adopter.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Adopter not found.");
        }
        return adopter.get();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/{id}/pets")
    List<Pet> findAllPets(@PathVariable Integer id){
        Optional<Adopter> adopter = adopterService.findById(id);
        if (adopter.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Adopter not found.");
        }
        System.out.println(adopterService.getAllAdopterPets(id));
        return adopterService.getAllAdopterPets(id);


    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createAdopter(@Valid @RequestBody Adopter adopter){
        adopterService.create(adopter);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void updateAdopter(@Valid @RequestBody Adopter adopter, @RequestParam Integer id){
        adopterService.update(adopter, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteAdopter(@PathVariable Integer id){
        adopterService.delete(id);
    }



}
