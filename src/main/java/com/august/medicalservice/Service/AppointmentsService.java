package com.august.medicalservice.Service;

import com.august.medicalservice.Repositories.DoctorAppointmentsRepository;
import com.august.medicalservice.models.DoctorAppointments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentsService {

    private final DoctorAppointmentsRepository doctorAppointmentsRepository;

    public AppointmentsService(DoctorAppointmentsRepository doctorAppointmentsRepository) {
        this.doctorAppointmentsRepository = doctorAppointmentsRepository;
    }

    public List<DoctorAppointments> getByTime(String receptionTime){
        return doctorAppointmentsRepository.findByReceptionTime(receptionTime);
    }

    public void appoint(Boolean isRecorded, String user, Integer doctorId){
        doctorAppointmentsRepository.createUserRecord(isRecorded, user, doctorId);
    }
}
