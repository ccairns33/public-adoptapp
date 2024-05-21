package com.expeditors.PetAdoptionAgency.repositories;

import com.expeditors.PetAdoptionAgency.domain.JpaAdopter;
import lombok.ToString;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Profile("jpa-dev")
@Repository
public interface AdopterRepository extends CrudRepository<JpaAdopter, Integer> {
}
