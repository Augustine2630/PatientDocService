package com.august.medicalservice.Service;

import com.august.medicalservice.Repositories.DoctorDataRepository;
import com.august.medicalservice.models.DoctorData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorDataRepository doctorDataRepository;

    public DoctorService(DoctorDataRepository doctorDataRepository) {
        this.doctorDataRepository = doctorDataRepository;
    }

    public List<DoctorData> getAllDoctors(){
        return doctorDataRepository.findAll();
    }

    @Transactional
    public void saveDoctor(DoctorData doctorData){
        doctorDataRepository.save(doctorData);
    }
}
