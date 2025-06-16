package com.onboardly.controller;

import com.onboardly.dto.ColaboradorRequestDTO;
import com.onboardly.dto.ColaboradorResponseDTO;
import com.onboardly.dto.OnboardingCompletionRequestDTO;
import com.onboardly.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Added CORS configuration here for quick testing
@RequestMapping("/api/colaboradores")
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    @Autowired
    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @GetMapping
    public ResponseEntity<List<ColaboradorResponseDTO>> getAllColaboradores() {
        List<ColaboradorResponseDTO> colaboradores = colaboradorService.getAllColaboradores();
        return new ResponseEntity<>(colaboradores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorResponseDTO> getColaboradorById(@PathVariable Long id) {
        ColaboradorResponseDTO colaborador = colaboradorService.getColaboradorById(id);
        return new ResponseEntity<ColaboradorResponseDTO>(colaborador, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ColaboradorResponseDTO> createColaborador(
            @Valid @RequestBody ColaboradorRequestDTO colaboradorRequestDTO) {
        ColaboradorResponseDTO createdColaborador = colaboradorService.createColaborador(colaboradorRequestDTO);
        return new ResponseEntity<ColaboradorResponseDTO>(createdColaborador, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/completar")
    public ResponseEntity<ColaboradorResponseDTO> completeOnboarding(@PathVariable Long id,
            @Valid @RequestBody OnboardingCompletionRequestDTO completionRequestDTO) {
        ColaboradorResponseDTO updatedColaborador = colaboradorService.completeOnboarding(id,
                completionRequestDTO.getTipo());
        return new ResponseEntity<ColaboradorResponseDTO>(updatedColaborador, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColaborador(@PathVariable Long id) {
        colaboradorService.deleteColaborador(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}