package com.august.medicalservice.Repositories;

import com.august.medicalservice.models.DoctorData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorDataRepository extends JpaRepository<DoctorData, Integer> {
}