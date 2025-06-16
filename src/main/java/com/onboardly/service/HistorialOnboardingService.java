package com.onboardly.service;

import com.onboardly.model.HistorialOnboarding;
import com.onboardly.repository.HistorialOnboardingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialOnboardingService {

    private final HistorialOnboardingRepository historialOnboardingRepository;

    @Autowired
    public HistorialOnboardingService(HistorialOnboardingRepository historialOnboardingRepository) {
        this.historialOnboardingRepository = historialOnboardingRepository;
    }

    public HistorialOnboarding saveHistorial(HistorialOnboarding historial) {
        return historialOnboardingRepository.save(historial);
    }
}