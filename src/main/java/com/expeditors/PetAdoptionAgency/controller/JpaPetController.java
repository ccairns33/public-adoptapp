package com.expeditors.PetAdoptionAgency.controller;

import com.expeditors.PetAdoptionAgency.domain.JpaAdopter;
import com.expeditors.PetAdoptionAgency.domain.JpaPet;
import com.expeditors.PetAdoptionAgency.domain.dto.JpaPetDTO;
import com.expeditors.PetAdoptionAgency.mappers.Mapper;
import com.expeditors.PetAdoptionAgency.service.JpaPetService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("jpa-dev")
@RestController // presentation layer
@RequestMapping("/api/pets")
public class JpaPetController {

    private Mapper<JpaPet, JpaPetDTO> petMapper;

    private JpaPetService jpaPetService;

    public JpaPetController(Mapper<JpaPet, JpaPetDTO> petMapper, JpaPetService jpaPetService) {
        this.petMapper = petMapper;
        this.jpaPetService = jpaPetService;
    }


    @PostMapping()
    public ResponseEntity<JpaPetDTO> createPet(@RequestBody JpaPetDTO jpaPetDTO){
        // map dto to entity to use in service and persistence layers
        JpaPet petEntity = petMapper.mapFrom(jpaPetDTO);
        JpaPet savedPetEntity = jpaPetService.createPet(petEntity);
        JpaPetDTO savedPetDTO = petMapper.mapTo(savedPetEntity);

        return new ResponseEntity<>(savedPetDTO, HttpStatus.CREATED);


    }
}
