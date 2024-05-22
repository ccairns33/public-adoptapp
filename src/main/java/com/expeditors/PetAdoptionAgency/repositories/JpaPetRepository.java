package com.expeditors.PetAdoptionAgency.repositories;

import com.expeditors.PetAdoptionAgency.domain.JpaAdopter;
import com.expeditors.PetAdoptionAgency.domain.JpaPet;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Profile("jpa-dev")
public interface JpaPetRepository extends CrudRepository<JpaPet, Integer> {

    @Query("SELECT p from JpaPet p where p.jpaAdopter is not null ")
    Iterable<JpaPet> findAllPetsWithAdopters();

    @Query("SELECT p from JpaPet p where p.jpaAdopter is null ")
    Iterable<JpaPet> findAllPetsWithoutAdopters();

    @Query("SELECT a from JpaPet p inner join p.jpaAdopter as a where p.id = ?1")
    Iterable<JpaAdopter> findAdopterByPetId(Integer id);

}
