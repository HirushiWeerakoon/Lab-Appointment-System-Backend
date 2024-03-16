package com.labappointment.labappointmentsystem.repository;

import com.labappointment.labappointmentsystem.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepository extends MongoRepository<Appointment,String> {

//    List<Patient> findBySeverity(int severity);
//
//    @Query("{ assignee: ?0 }")
//    List<Patient> getTasksByAssignee(String assignee);
}
