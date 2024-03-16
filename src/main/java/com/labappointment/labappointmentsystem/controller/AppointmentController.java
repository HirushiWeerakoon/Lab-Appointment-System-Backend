package com.labappointment.labappointmentsystem.controller;

import com.labappointment.labappointmentsystem.model.Appointment;
import com.labappointment.labappointmentsystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment createAppointment(@RequestBody Appointment appointment){
        return service.addAppointment(appointment);
    }

    @GetMapping
    public List<Appointment> getAppointment() {
        return service.findAllAppointment();
    }

    @GetMapping("/{appointmentId}")
    public Appointment getAppointment(@PathVariable String appointmentId){
        return service.getAppointmentByAppointmentId(appointmentId);
    }

//    @GetMapping("/severity/{severity}")
//    public List<Task> findTaskUsingSeverity(@PathVariable int severity){
//        return service.getTaskBySeverity(severity);
//    }
//
//    @GetMapping("/assignee/{assignee}")
//    public List<Task> getTaskByAssignee(@PathVariable String assignee){
//        return service.getTaskByAssignee(assignee);
//    }

    @PutMapping
    public Appointment modifyAppointment(@RequestBody Appointment appointment){
        return service.updateAppointment(appointment);
    }

    @DeleteMapping("/{appointmentId}")
    public String deleteAppointment(@PathVariable String appointmentId){
        return service.deleteAppointment(appointmentId);
    }
}
