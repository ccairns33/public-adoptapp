package com.expeditors.PetAdoptionAgency.mappers.impl;

import com.expeditors.PetAdoptionAgency.domain.JpaPet;
import com.expeditors.PetAdoptionAgency.domain.dto.JpaPetDTO;
import com.expeditors.PetAdoptionAgency.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class JpaPetMapper implements Mapper<JpaPet, JpaPetDTO> {
    private ModelMapper modelMapper;

    public JpaPetMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public JpaPetDTO mapTo(JpaPet jpaPet) {
        return modelMapper.map(jpaPet, JpaPetDTO.class);
    }

    @Override
    public JpaPet mapFrom(JpaPetDTO jpaPetDTO) {
        return modelMapper.map(jpaPetDTO, JpaPet.class);
    }
}
