package com.expeditors.PetAdoptionAgency.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Profile("jpa-dev")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="adopters")
@Getter
@Setter
public class JpaAdopter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adopter_id_seq")
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String phoneNumber;
    @NonNull
    private LocalDate dateOfAdoption;

//    private JpaPet jpaPet;

}
