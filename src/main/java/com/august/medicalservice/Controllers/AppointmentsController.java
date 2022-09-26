package com.august.medicalservice.Controllers;

import com.august.medicalservice.Service.AppointmentsService;
import com.august.medicalservice.models.DoctorAppointments;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
