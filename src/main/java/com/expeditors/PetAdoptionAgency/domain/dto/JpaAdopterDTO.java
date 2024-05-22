package com.expeditors.PetAdoptionAgency.domain.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

//POJO
@Profile("jpa-dev")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class JpaAdopterDTO {
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String phoneNumber;
    @NonNull
    private LocalDate dateOfAdoption;
}
