package com.expeditors.PetAdoptionAgency.mappers.impl;

import com.expeditors.PetAdoptionAgency.domain.JpaAdopter;
import com.expeditors.PetAdoptionAgency.domain.dto.JpaAdopterDTO;
import com.expeditors.PetAdoptionAgency.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("jpa-dev")
@Component
public class JpaAdopterMapper implements Mapper<JpaAdopter, JpaAdopterDTO> {

    private ModelMapper modelMapper;

    public JpaAdopterMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public JpaAdopterDTO mapTo(JpaAdopter adopter) {
        return modelMapper.map(adopter, JpaAdopterDTO.class);
    }

    @Override
    public JpaAdopter mapFrom(JpaAdopterDTO jpaAdopterDTO) {
        return modelMapper.map(jpaAdopterDTO, JpaAdopter.class);
    }
}
