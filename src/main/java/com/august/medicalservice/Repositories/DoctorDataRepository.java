package com.august.medicalservice.Repositories;

import com.august.medicalservice.models.DoctorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorDataRepository extends JpaRepository<DoctorData, Integer> {

    List<DoctorData> findAllByDoctorSpeciality(String speciality);

}