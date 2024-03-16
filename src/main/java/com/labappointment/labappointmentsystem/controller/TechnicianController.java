package com.labappointment.labappointmentsystem.controller;

import com.labappointment.labappointmentsystem.model.Technician;
import com.labappointment.labappointmentsystem.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technicians")
public class TechnicianController {

    @Autowired
    private TechnicianService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Technician createTechnician(@RequestBody Technician technician){
        return service.addTechnician(technician);
    }

    @GetMapping
    public List<Technician> getTechnician() {
        return service.findAllTechnician();
    }

    @GetMapping("/{technicianId}")
    public Technician getTechnician(@PathVariable String technicianId){
        return service.getTechnicianByTechnicianId(technicianId);
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
    public Technician modifyTechnician(@RequestBody Technician technician){
        return service.updateTechnician(technician);
    }

    @DeleteMapping("/{technicianId}")
    public String deleteTechnician(@PathVariable String technicianId){
        return service.deleteTechnician(technicianId);
    }
}
