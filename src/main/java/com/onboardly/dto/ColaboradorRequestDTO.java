package com.onboardly.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ColaboradorRequestDTO {

    @NotBlank
    @Size(max = 100)
    private String nombreCompleto;

    @NotBlank
    @Email
    private String correo;

    private LocalDate fechaIngreso;

    private Long eventoTecnicoId;

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

    public Long getEventoTecnicoId() {
        return eventoTecnicoId;
    }

    public void setEventoTecnicoId(Long eventoTecnicoId) {
        this.eventoTecnicoId = eventoTecnicoId;
    }
}