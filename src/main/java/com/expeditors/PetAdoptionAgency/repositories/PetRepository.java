package com.expeditors.PetAdoptionAgency.repositories;

import com.expeditors.PetAdoptionAgency.domain.JpaPet;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("jpa-dev")
public interface PetRepository extends CrudRepository<JpaPet, Integer> {
}
