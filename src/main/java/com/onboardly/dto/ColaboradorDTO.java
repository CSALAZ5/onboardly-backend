package com.onboardly.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class ColaboradorDTO {

    private Long id;

    @NotBlank(message = "El nombre completo es obligatorio")
    private String nombreCompleto;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El formato del correo no es válido")
    private String correo;

    private LocalDate fechaIngreso;

    private boolean onboardingBienvenida;

    private boolean onboardingTecnico;

    private Long eventoTecnicoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean isOnboardingBienvenida() {
        return onboardingBienvenida;
    }

    public void setOnboardingBienvenida(boolean onboardingBienvenida) {
        this.onboardingBienvenida = onboardingBienvenida;
    }

    public boolean isOnboardingTecnico() {
        return onboardingTecnico;
    }

    public void setOnboardingTecnico(boolean onboardingTecnico) {
        this.onboardingTecnico = onboardingTecnico;
    }

    public Long getEventoTecnicoId() {
        return eventoTecnicoId;
    }

    public void setEventoTecnicoId(Long eventoTecnicoId) {
        this.eventoTecnicoId = eventoTecnicoId;
    }
}