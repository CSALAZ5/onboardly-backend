package com.onboardly.dto;

import java.time.LocalDate;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColaboradorResponseDTO {

    private Long id;
    private String nombreCompleto;
    private String correo;
    private LocalDate fechaIngreso;
    private boolean onboardingBienvenida;
    private boolean onboardingTecnico;
    private EventoOnboardingTecnicoResponseDTO eventoTecnico;
    
}