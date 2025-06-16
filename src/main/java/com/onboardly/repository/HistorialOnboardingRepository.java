package com.onboardly.repository;

import com.onboardly.model.HistorialOnboarding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialOnboardingRepository extends JpaRepository<HistorialOnboarding, Long> {
}