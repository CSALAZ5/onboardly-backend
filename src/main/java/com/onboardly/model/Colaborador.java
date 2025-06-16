package com.onboardly.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "colaboradores")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_completo", nullable = false, length = 100)
    private String nombreCompleto;

    @Column(name = "correo", nullable = false, unique = true, length = 100)
    private String correo;

    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    @Column(name = "onboarding_bienvenida", nullable = false)
    private boolean onboardingBienvenida = false;

    @Column(name = "onboarding_tecnico", nullable = false)
    private boolean onboardingTecnico = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evento_tecnico_id")
    private EventoOnboardingTecnico eventoTecnico;

    public Colaborador() {
    }

    public Colaborador(String nombreCompleto, String correo, LocalDate fechaIngreso, boolean onboardingBienvenida, boolean onboardingTecnico, EventoOnboardingTecnico eventoTecnico) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.fechaIngreso = fechaIngreso;
        this.onboardingBienvenida = onboardingBienvenida;
        this.onboardingTecnico = onboardingTecnico;
        this.eventoTecnico = eventoTecnico;
    }

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