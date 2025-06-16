package com.onboardly.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class OnboardingCompletionRequestDTO {

    @NotBlank(message = "El tipo de onboarding es obligatorio")
    @Pattern(regexp = "bienvenida|tecnico", message = "El tipo de onboarding debe ser 'bienvenida' o 'tecnico'")
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}