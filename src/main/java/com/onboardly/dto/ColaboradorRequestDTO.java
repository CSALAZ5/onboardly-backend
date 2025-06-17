package com.onboardly.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColaboradorRequestDTO {

    @NotBlank
    @Size(max = 100)
    private String nombreCompleto;

    @NotBlank
    @Email
    private String correo;

    private LocalDate fechaIngreso;

    private boolean onboardingBienvenida;
    private boolean onboardingTecnico;
    private Long eventoTecnico;
}