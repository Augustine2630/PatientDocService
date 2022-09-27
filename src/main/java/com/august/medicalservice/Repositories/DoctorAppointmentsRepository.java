package com.august.medicalservice.Repositories;

import com.august.medicalservice.models.DoctorAppointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorAppointmentsRepository extends JpaRepository<DoctorAppointments, Integer> {

    List<DoctorAppointments> findByReceptionTime(String receptionTime);

    @Query(nativeQuery = true,
            value = "UPDATE doctor_appointments SET is_recorded = ?1, who_recorded = ?2" +
                    "where reception_time = '9.00' and doctor_id = ?3")
    void createUserRecord(Boolean isRecorded, String whoRecorded, Integer doctorId);

}