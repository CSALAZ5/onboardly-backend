package com.onboardly.repository;

import com.onboardly.model.EventoOnboardingTecnico;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoOnboardingTecnicoRepository extends JpaRepository<EventoOnboardingTecnico, Long> {
    List<EventoOnboardingTecnico> findByFechaInicioBetween(LocalDate startDate, LocalDate endDate);
}