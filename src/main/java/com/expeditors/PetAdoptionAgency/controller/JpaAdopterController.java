package com.expeditors.PetAdoptionAgency.controller;

import com.expeditors.PetAdoptionAgency.domain.JpaAdopter;
import com.expeditors.PetAdoptionAgency.domain.dto.JpaAdopterDTO;
import com.expeditors.PetAdoptionAgency.mappers.Mapper;
import com.expeditors.PetAdoptionAgency.service.JpaAdopterService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Profile("jpa-dev")
@RestController // presentation layer
@RequestMapping("/api/adopters")
public class JpaAdopterController {

    private JpaAdopterService jpaAdopterService;

    private Mapper<JpaAdopter, JpaAdopterDTO> adopterMapper;

    public JpaAdopterController(JpaAdopterService jpaAdopterService, Mapper<JpaAdopter, JpaAdopterDTO> adopterMapper) {
        this.jpaAdopterService = jpaAdopterService;
        this.adopterMapper = adopterMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public JpaAdopterDTO createAdopter(@RequestBody JpaAdopterDTO adopterDTO){
        JpaAdopter adopterEntity = adopterMapper.mapFrom(adopterDTO);
        JpaAdopter savedAdopterEntity = jpaAdopterService.createAdopter(adopterEntity);

        return adopterMapper.mapTo(savedAdopterEntity);
    }

}
