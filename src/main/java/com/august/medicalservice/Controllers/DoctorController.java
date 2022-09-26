package com.august.medicalservice.Controllers;

import com.august.medicalservice.DTO.DoctorDTO;
import com.august.medicalservice.Service.DoctorService;
import com.august.medicalservice.models.DoctorData;
import com.august.medicalservice.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doc")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/get-docs")
    public List<DoctorData> getAllDoctors(){
        return doctorService.getAllDoctors();
    }


    @GetMapping("/get-doc/{id}")
    public Optional<DoctorData> getDoctorById(@PathVariable(value = "id", required = true) int id){
        return doctorService.getDoctor(id);
    }

    @PostMapping("/new-doc")
    public ResponseEntity<HttpStatus> createDoctor(@RequestBody DoctorDTO doctorDTO, BindingResult bindingResult, User user){
        if(bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors){
                errorMsg.append(error.getField()).append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }

            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
        doctorService.saveDoctor(convertToDoctor(doctorDTO));
        return ResponseEntity.ok((HttpStatus.OK));
    }

    @GetMapping("/get-spec")
    public List<DoctorData> showDoctorAppointments(@RequestParam(name = "speciality") String speciality){
        return doctorService.getDoctorsBySpeciality(speciality);
    }



    private DoctorData convertToDoctor(DoctorDTO doctorDTO){
        DoctorData doctorData = new DoctorData();

        doctorData.setFirstName(doctorDTO.getFirstName());
        doctorData.setLastName(doctorDTO.getLastName());
        doctorData.setDoctorSpeciality(doctorDTO.getDoctorSpeciality());
        doctorData.setSpecialityCode(doctorDTO.getSpecialityCode());

        return doctorData;
    }
}
