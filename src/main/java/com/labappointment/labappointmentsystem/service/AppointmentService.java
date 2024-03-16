package com.labappointment.labappointmentsystem.service;

import com.labappointment.labappointmentsystem.model.Appointment;
import com.labappointment.labappointmentsystem.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    //CRUD  CREATE , READ , UPDATE , DELETE

    public Appointment addAppointment(Appointment appointment) {
        appointment.setAppointmentId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(appointment);
    }

    public List<Appointment> findAllAppointment() {
        return repository.findAll();
    }

    public Appointment getAppointmentByAppointmentId(String appointmentId){
        return repository.findById(appointmentId).get();
    }

//    public List<Task> getTaskBySeverity(int severity){
//        return  repository.findBySeverity(severity);
//    }
//
//    public List<Task> getTaskByAssignee(String assignee){
//        return repository.getTasksByAssignee(assignee);
//    }

    public Appointment updateAppointment(Appointment appointmentRequest){
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        Appointment existingAppointment = repository.findById(appointmentRequest.getAppointmentId()).get();
        existingAppointment.setDate(appointmentRequest.getDate());
        existingAppointment.setTime(appointmentRequest.getTime());
        existingAppointment.setDoctorName(appointmentRequest.getDoctorName());
        existingAppointment.setTest(appointmentRequest.getTest());
        return repository.save(appointmentRequest);
    }

    public String deleteAppointment(String appointmentId){
        repository.deleteById(appointmentId);
        return appointmentId+" appointment deleted from dashboard ";
    }
}
