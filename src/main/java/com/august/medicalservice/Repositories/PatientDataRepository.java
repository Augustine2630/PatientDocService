package com.august.medicalservice.Repositories;

import com.august.medicalservice.models.PatientData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDataRepository extends JpaRepository<PatientData, Integer> {
}