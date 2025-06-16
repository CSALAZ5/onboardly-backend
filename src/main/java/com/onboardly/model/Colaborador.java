package com.onboardly.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "colaboradores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private boolean onboardingBienvenida;

    @Column(name = "onboarding_tecnico", nullable = false)
    private boolean onboardingTecnico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evento_tecnico_id")
    private EventoOnboardingTecnico eventoTecnico;

}