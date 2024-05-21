package com.expeditors.PetAdoptionAgency.mappers;

import org.springframework.context.annotation.Profile;

@Profile("jpa-dev")
public interface Mapper<A,B> {

    B mapTo(A a);

    A mapFrom(B b);
}
