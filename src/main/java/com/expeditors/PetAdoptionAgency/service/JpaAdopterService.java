package com.expeditors.PetAdoptionAgency.service;

import com.expeditors.PetAdoptionAgency.domain.JpaAdopter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("jpa-dev")
@Service
public interface JpaAdopterService {
    JpaAdopter createAdopter(JpaAdopter adopter);
}
