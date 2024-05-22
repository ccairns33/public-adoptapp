package com.expeditors.PetAdoptionAgency.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Profile;

import static jakarta.persistence.EnumType.STRING;

@Profile("jpa-dev")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pets")
@Getter
@Setter
public class JpaPet {

    public enum PetType {
        CAT,
        DOG,
        TURTLE
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_id_seq")
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private String breed;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="adopter_id")
    private JpaAdopter adopter;

    @NonNull
    @Enumerated(STRING)
    private PetType type;

}
