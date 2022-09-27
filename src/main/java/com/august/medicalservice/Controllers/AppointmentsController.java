package com.august.medicalservice.Controllers;

import com.august.medicalservice.DTO.UserAppointDTO;
import com.august.medicalservice.Service.AppointmentsService;
import com.august.medicalservice.Utils.Exceptions.AppointErrorResponse;
import com.august.medicalservice.Utils.Exceptions.AppointException;
import com.august.medicalservice.Utils.Exceptions.DoctorErrorResponse;
import com.august.medicalservice.Utils.Exceptions.DoctorNotCreatedException;
import com.august.medicalservice.models.DoctorAppointments;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/rec")
public class AppointmentsController {

    private final AppointmentsService appointmentsService;

    public AppointmentsController(AppointmentsService appointmentsService) {
        this.appointmentsService = appointmentsService;
    }

    @GetMapping("/appo-time")
    public List<DoctorAppointments> getAllByTime(@RequestParam("time") String time){
        return appointmentsService.getByTime(time);
    }

    @PostMapping("/make-appoint")
    public ResponseEntity<HttpStatus> makeAnAppointment(Boolean isRecorded,
                                                        String userData, Integer doctorId,
                                                        BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors){
                errorMsg.append(error.getField()).append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }

            throw new AppointException(errorMsg.toString());
        }

        appointmentsService.appoint(isRecorded, userData, doctorId);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler()
    private ResponseEntity<AppointErrorResponse> handleException(AppointException e){
        AppointErrorResponse response = new AppointErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private DoctorAppointments convertToAppoint(UserAppointDTO userAppointDTO, Principal principal){
        DoctorAppointments doctorAppointments = new DoctorAppointments();

        doctorAppointments.setIsRecorded(true);
        doctorAppointments.setWhoRecorded(principal.getName());
        return doctorAppointments;
    }


}
