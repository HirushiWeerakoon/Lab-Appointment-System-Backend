package com.labappointment.labappointmentsystem.service;

import com.labappointment.labappointmentsystem.model.Patient;
import com.labappointment.labappointmentsystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    //CRUD  CREATE , READ , UPDATE , DELETE


    public Patient addPatient(Patient patient) {
        patient.setPatientId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(patient);
    }

    public List<Patient> findAllPatient() {
        return repository.findAll();
    }

    public Patient getPatientByPatientId(String patientId){
        return repository.findById(patientId).get();
    }

//    public List<Task> getTaskBySeverity(int severity){
//        return  repository.findBySeverity(severity);
//    }
//
//    public List<Task> getTaskByAssignee(String assignee){
//        return repository.getTasksByAssignee(assignee);
//    }

    public Patient updatePatient(Patient patientRequest){
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        Patient existingPatient = repository.findById(patientRequest.getPatientId()).get();
        existingPatient.setName(patientRequest.getName());
        existingPatient.setAge(patientRequest.getAge());
        existingPatient.setEmail(patientRequest.getEmail());
        existingPatient.setContactNo(patientRequest.getContactNo());
        return repository.save(existingPatient);
    }

    public String deletePatient(String patientId){
        repository.deleteById(patientId);
        return patientId+" patient deleted from dashboard ";
    }
}
