package com.labappointment.labappointmentsystem.service;

import com.labappointment.labappointmentsystem.model.Technician;
import com.labappointment.labappointmentsystem.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepository repository;

    //CRUD  CREATE , READ , UPDATE , DELETE


    public Technician addTechnician(Technician technician) {
        technician.setTechnicianId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(technician);
    }

    public List<Technician> findAllTechnician() {
        return repository.findAll();
    }

    public Technician getTechnicianByTechnicianId(String technicianId){
        return repository.findById(technicianId).get();
    }

//    public List<Task> getTaskBySeverity(int severity){
//        return  repository.findBySeverity(severity);
//    }
//
//    public List<Task> getTaskByAssignee(String assignee){
//        return repository.getTasksByAssignee(assignee);
//    }

    public Technician updateTechnician(Technician technicianRequest){
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        Technician existingTechnician = repository.findById(technicianRequest.getTechnicianId()).get();
        existingTechnician.setName(technicianRequest.getName());
        return repository.save(existingTechnician);
    }

    public String deleteTechnician(String technicianId){
        repository.deleteById(technicianId);
        return technicianId+" technician deleted from dashboard ";
    }
}
