package com.expeditors.PetAdoptionAgency.domain.dto;

import com.expeditors.PetAdoptionAgency.domain.JpaAdopter;
import com.expeditors.PetAdoptionAgency.domain.JpaPet;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Profile;

import static jakarta.persistence.EnumType.STRING;

//POJO
@Profile("jpa-dev")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class JpaPetDTO {

    public enum PetType {
        CAT,
        DOG,
        TURTLE
    }

    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private String breed;

    private JpaAdopterDTO adopter;

    @NonNull
    @Enumerated(STRING)
    private JpaPetDTO.PetType type;
}
