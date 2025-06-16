package com.onboardly.dto;

import com.onboardly.model.EventoOnboardingTecnico;

import java.time.LocalDate;

public class ColaboradorResponseDTO {

    private Long id;
    private String nombreCompleto;
    private String correo;
    private LocalDate fechaIngreso;
    private boolean onboardingBienvenida;
    private boolean onboardingTecnico;
    private EventoOnboardingTecnico eventoTecnico; // Or a simplified DTO for EventoOnboardingTecnico

    // Getters and Setters

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

    public EventoOnboardingTecnico getEventoTecnico() {
        return eventoTecnico;
    }

    public void setEventoTecnico(EventoOnboardingTecnico eventoTecnico) {
        this.eventoTecnico = eventoTecnico;
    }
}