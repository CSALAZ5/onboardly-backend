package com.onboardly.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public class EventoCalendarioDTO {

    private Long id;

    @NotBlank(message = "El nombre del evento es obligatorio")
    private String nombre;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}