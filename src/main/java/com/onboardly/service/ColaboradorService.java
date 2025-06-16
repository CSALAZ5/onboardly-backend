package com.onboardly.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onboardly.dto.ColaboradorRequestDTO;
import com.onboardly.dto.ColaboradorResponseDTO;
import com.onboardly.dto.EventoOnboardingTecnicoResponseDTO;
import com.onboardly.exception.ResourceNotFoundException;
import com.onboardly.model.Colaborador;
import com.onboardly.model.EventoOnboardingTecnico;
import com.onboardly.model.HistorialOnboarding;
import com.onboardly.repository.ColaboradorRepository;
import com.onboardly.repository.EventoOnboardingTecnicoRepository;
import com.onboardly.repository.HistorialOnboardingRepository;

@Service
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;

    @Autowired
    private EventoOnboardingTecnicoRepository eventoOnboardingTecnicoRepository;

    @Autowired
    private HistorialOnboardingRepository historialOnboardingRepository;

    @Autowired
    public ColaboradorService(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }

    public List<ColaboradorResponseDTO> getAllColaboradores() {
        System.out.println("Fetching all colaboradores in service");
        List<Colaborador> colaboradores = colaboradorRepository.findAll();
        return colaboradores.stream()
                .map(this::convertToDto)
                .toList();
    }

    public ColaboradorResponseDTO getColaboradorById(Long id) {
        Colaborador colaborador = colaboradorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Colaborador not found with id: " + id));
        return convertToDto(colaborador);
    }

    public ColaboradorResponseDTO createColaborador(ColaboradorRequestDTO colaboradorRequestDTO) {
        Colaborador colaborador = convertToEntity(colaboradorRequestDTO);
        Colaborador savedColaborador = colaboradorRepository.save(colaborador);
        return convertToDto(savedColaborador);
    }

    public ColaboradorResponseDTO updateColaborador(Long id, ColaboradorRequestDTO updatedColaboradorDTO) {
        Optional<Colaborador> existingColaborador = colaboradorRepository.findById(id);

        if (existingColaborador.isPresent()) {
            Colaborador colaborador = existingColaborador.get();
            colaborador.setNombreCompleto(updatedColaboradorDTO.getNombreCompleto());
            colaborador.setCorreo(updatedColaboradorDTO.getCorreo());
            colaborador.setFechaIngreso(updatedColaboradorDTO.getFechaIngreso());
            // Onboarding status is updated via the PATCH endpoint

            if (updatedColaboradorDTO.getEventoTecnicoId() != null) {
                eventoOnboardingTecnicoRepository.findById(updatedColaboradorDTO.getEventoTecnicoId())
                        .ifPresent(colaborador::setEventoTecnico);
            } else {
                colaborador.setEventoTecnico(null);
            }

            Colaborador updatedColaborador = colaboradorRepository.save(colaborador);
            return convertToDto(updatedColaborador);
        } else {
            throw new ResourceNotFoundException("Colaborador not found with id: " + id);
        }
    }

    @Transactional
    public ColaboradorResponseDTO completeOnboarding(Long id, String tipo) {
        Optional<Colaborador> existingColaborador = colaboradorRepository.findById(id);

        if (existingColaborador.isPresent()) {
            Colaborador colaborador = existingColaborador.get();
            if ("bienvenida".equals(tipo)) {
                colaborador.setOnboardingBienvenida(true);
            } else if ("tecnico".equals(tipo)) {
                colaborador.setOnboardingTecnico(true);
            } else {
                throw new IllegalArgumentException("Tipo de onboarding inválido: " + tipo);
            }
            HistorialOnboarding historial = new HistorialOnboarding();
            historial.setColaborador(colaborador);
            historial.setTipo(tipo);
            historial.setFechaCompletado(java.time.LocalDate.now());
            historialOnboardingRepository.save(historial);
            Colaborador updatedColaborador = colaboradorRepository.save(colaborador);
            return convertToDto(updatedColaborador);
        } else {
            throw new ResourceNotFoundException("Colaborador not found with id: " + id);
        }
    }

    public Optional<ColaboradorResponseDTO> getColaboradorEntityById(Long id) {
        return Optional.empty();
    }

    public void deleteColaborador(Long id) {
        if (!colaboradorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Colaborador not found with id: " + id);
        }
        colaboradorRepository.deleteById(id);
    }

    private ColaboradorResponseDTO convertToDto(Colaborador colaborador) {
        System.out.println("Converting Colaborador to DTO: " + colaborador.getId());
        ColaboradorResponseDTO dto = new ColaboradorResponseDTO();
        dto.setId(colaborador.getId());
        dto.setNombreCompleto(colaborador.getNombreCompleto());
        dto.setCorreo(colaborador.getCorreo());
        dto.setFechaIngreso(colaborador.getFechaIngreso());
        dto.setOnboardingBienvenida(colaborador.isOnboardingBienvenida());
        dto.setOnboardingTecnico(colaborador.isOnboardingTecnico());
        if (colaborador.getEventoTecnico() != null) {
            EventoOnboardingTecnico evento = colaborador.getEventoTecnico();

            EventoOnboardingTecnicoResponseDTO eventoDTO = new EventoOnboardingTecnicoResponseDTO();
            eventoDTO.setId(evento.getId());
            eventoDTO.setNombre(evento.getNombre());
            eventoDTO.setFechaInicio(evento.getFechaInicio());
            eventoDTO.setFechaFin(evento.getFechaFin());

            System.out.println("Setting EventoTecnico for Colaborador: " + evento.getId());
            dto.setEventoTecnico(eventoDTO);
        }
        System.out.println("Converted Colaborador to DTO: " + dto.getId());
        return dto;
    }

    private Colaborador convertToEntity(ColaboradorRequestDTO dto) {
        Colaborador colaborador = new Colaborador();
        colaborador.setNombreCompleto(dto.getNombreCompleto());
        colaborador.setCorreo(dto.getCorreo());
        colaborador.setFechaIngreso(dto.getFechaIngreso());

        if (dto.getEventoTecnicoId() != null) {
            eventoOnboardingTecnicoRepository.findById(dto.getEventoTecnicoId())
                    .ifPresent(colaborador::setEventoTecnico);
        }
        return colaborador;
    }
}