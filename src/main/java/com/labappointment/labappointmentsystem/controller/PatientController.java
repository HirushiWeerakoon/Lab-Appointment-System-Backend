package com.labappointment.labappointmentsystem.controller;

import com.labappointment.labappointmentsystem.model.Patient;
import com.labappointment.labappointmentsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient createPatient(@RequestBody Patient patient){
        return service.addPatient(patient);
    }

    @GetMapping
    public List<Patient> getPatient() {
        return service.findAllPatient();
    }

    @GetMapping("/{patientId}")
    public Patient getPatient(@PathVariable String patientId){
        return service.getPatientByPatientId(patientId);
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
    public Patient modifyPatient(@RequestBody Patient patient){
        return service.updatePatient(patient);
    }

    @DeleteMapping("/{patientId}")
    public String deletePatient(@PathVariable String patientId){
        return service.deletePatient(patientId);
    }
}
