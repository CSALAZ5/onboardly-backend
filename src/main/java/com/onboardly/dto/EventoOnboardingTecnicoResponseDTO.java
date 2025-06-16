package com.onboardly.dto;

import java.time.LocalDate;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoOnboardingTecnicoResponseDTO {

    private Long id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}