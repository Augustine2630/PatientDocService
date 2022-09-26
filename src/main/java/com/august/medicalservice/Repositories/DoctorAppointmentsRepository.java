package com.august.medicalservice.Repositories;

import com.august.medicalservice.models.DoctorAppointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorAppointmentsRepository extends JpaRepository<DoctorAppointments, Integer> {

    List<DoctorAppointments> findByReceptionTime(String receptionTime);

}