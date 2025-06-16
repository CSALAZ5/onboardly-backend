package com.onboardly.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import lombok.*;

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

    private Long eventoTecnicoId;
}