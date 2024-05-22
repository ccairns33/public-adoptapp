package com.expeditors.PetAdoptionAgency.service.impl;

import com.expeditors.PetAdoptionAgency.domain.JpaPet;
import com.expeditors.PetAdoptionAgency.repositories.JpaPetRepository;
import com.expeditors.PetAdoptionAgency.service.JpaPetService;
import org.springframework.stereotype.Service;

@Service
public class JpaPetServiceImpl implements JpaPetService {
    private JpaPetRepository jpaPetRepository;

    public JpaPetServiceImpl(JpaPetRepository jpaPetRepository) {
        this.jpaPetRepository = jpaPetRepository;
    }

    @Override
    public JpaPet createPet(JpaPet jpaPet) {
        return jpaPetRepository.save(jpaPet);
    }
}
