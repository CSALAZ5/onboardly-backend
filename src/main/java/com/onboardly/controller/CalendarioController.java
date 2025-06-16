package com.onboardly.controller;

import com.onboardly.dto.EventoOnboardingTecnicoRequestDTO;
import com.onboardly.dto.EventoOnboardingTecnicoResponseDTO;
import com.onboardly.service.EventoOnboardingTecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/calendario")
public class CalendarioController {

    private final EventoOnboardingTecnicoService eventoOnboardingTecnicoService;

    @Autowired
    public CalendarioController(EventoOnboardingTecnicoService eventoOnboardingTecnicoService) {
        this.eventoOnboardingTecnicoService = eventoOnboardingTecnicoService;
    }

    @GetMapping
    public ResponseEntity<List<EventoOnboardingTecnicoResponseDTO>> getAllEventos() {
        List<EventoOnboardingTecnicoResponseDTO> eventos = eventoOnboardingTecnicoService.getAllEventos();
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoOnboardingTecnicoResponseDTO> getEventoById(@PathVariable Long id) {
        Optional<EventoOnboardingTecnicoResponseDTO> evento = Optional.of(eventoOnboardingTecnicoService.getEventoById(id));
        return evento.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EventoOnboardingTecnicoResponseDTO> createEvento(@Valid @RequestBody EventoOnboardingTecnicoRequestDTO evento) {
        EventoOnboardingTecnicoResponseDTO createdEvento = eventoOnboardingTecnicoService.createEvento(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoOnboardingTecnicoResponseDTO> updateEvento(@PathVariable Long id, @Valid @RequestBody EventoOnboardingTecnicoRequestDTO eventoDetails) {
        EventoOnboardingTecnicoResponseDTO updatedEvento = eventoOnboardingTecnicoService.updateEvento(id, eventoDetails);
 return ResponseEntity.ok(updatedEvento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id) {
        eventoOnboardingTecnicoService.deleteEvento(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/verificar")
    public ResponseEntity<String> verificarOnboardingTecnicoProximo() {
        List<EventoOnboardingTecnicoResponseDTO> upcomingEvents = eventoOnboardingTecnicoService.getUpcomingEventos();
        if (!upcomingEvents.isEmpty()) {
            System.out.println("ALERT: There are upcoming technical onboardings within the next 7 days!");
            return ResponseEntity.ok("Upcoming technical onboardings detected.");
        }
        return ResponseEntity.ok("No upcoming technical onboardings within the next 7 days.");
    }
}