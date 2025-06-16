package com.onboardly.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "historial_onboarding")
public class HistorialOnboarding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "colaborador_id", nullable = false)
    private Colaborador colaborador;

    @Column(nullable = false)
    private String tipo; // "bienvenida" or "tecnico"

    @Column
    private LocalDate fechaCompletado;

    public HistorialOnboarding() {
    }

    public HistorialOnboarding(Colaborador colaborador, String tipo, LocalDate fechaCompletado) {
        this.colaborador = colaborador;
        this.tipo = tipo;
        this.fechaCompletado = fechaCompletado;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaCompletado() {
        return fechaCompletado;
    }

    public void setFechaCompletado(LocalDate fechaCompletado) {
        this.fechaCompletado = fechaCompletado;
    }
}