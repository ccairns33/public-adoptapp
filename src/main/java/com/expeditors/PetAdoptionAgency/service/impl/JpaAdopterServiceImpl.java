package com.expeditors.PetAdoptionAgency.service.impl;

import com.expeditors.PetAdoptionAgency.domain.JpaAdopter;
import com.expeditors.PetAdoptionAgency.repositories.JpaAdopterRepository;
import com.expeditors.PetAdoptionAgency.service.JpaAdopterService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("jpa-dev")
@Service // service layer
public class JpaAdopterServiceImpl implements JpaAdopterService {

    private JpaAdopterRepository jpaAdopterRepository;

    public JpaAdopterServiceImpl(JpaAdopterRepository jpaAdopterRepository) {
        this.jpaAdopterRepository = jpaAdopterRepository;
    }

    @Override
    public JpaAdopter createAdopter(JpaAdopter jpaAdopter) {
        return jpaAdopterRepository.save(jpaAdopter);

    }
}
