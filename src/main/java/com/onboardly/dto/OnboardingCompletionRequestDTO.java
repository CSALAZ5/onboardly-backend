package com.onboardly.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OnboardingCompletionRequestDTO {

    @NotBlank(message = "El tipo de onboarding es obligatorio")
    @Pattern(regexp = "bienvenida|tecnico", message = "El tipo de onboarding debe ser 'bienvenida' o 'tecnico'")
    private String tipo;
}