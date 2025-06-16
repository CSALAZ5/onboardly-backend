package com.onboardly.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onboardly.dto.ColaboradorRequestDTO;
import com.onboardly.dto.ColaboradorResponseDTO;
import com.onboardly.dto.OnboardingCompletionRequestDTO;
import com.onboardly.service.ColaboradorService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*") // Added CORS configuration here for quick testing
@RequestMapping("/api/colaboradores")
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @GetMapping
    public ResponseEntity<List<ColaboradorResponseDTO>> getAllColaboradores() {
        System.out.println("Fetching all colaboradores");
        List<ColaboradorResponseDTO> colaboradores = colaboradorService.getAllColaboradores();
        return new ResponseEntity<>(colaboradores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorResponseDTO> getColaboradorById(@PathVariable Long id) {
        ColaboradorResponseDTO colaborador = colaboradorService.getColaboradorById(id);
        return new ResponseEntity<>(colaborador, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ColaboradorResponseDTO> createColaborador(
            @Valid @RequestBody ColaboradorRequestDTO colaboradorRequestDTO) {
        ColaboradorResponseDTO createdColaborador = colaboradorService.createColaborador(colaboradorRequestDTO);
        return new ResponseEntity<>(createdColaborador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColaboradorResponseDTO> actualizarColaborador(@PathVariable Long id, @RequestBody ColaboradorRequestDTO datos) {
        ColaboradorResponseDTO updatedColaborador = colaboradorService.updateColaborador(id, datos);
        return new ResponseEntity<>(updatedColaborador, HttpStatus.OK);
    }

    @PatchMapping("/{id}/completar")
    public ResponseEntity<ColaboradorResponseDTO> completeOnboarding(@PathVariable Long id,
            @Valid @RequestBody OnboardingCompletionRequestDTO completionRequestDTO) {
        ColaboradorResponseDTO updatedColaborador = colaboradorService.completeOnboarding(id,
                completionRequestDTO.getTipo());
        return new ResponseEntity<>(updatedColaborador, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColaborador(@PathVariable Long id) {
        colaboradorService.deleteColaborador(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}