package com.labappointment.labappointmentsystem.repository;

import com.labappointment.labappointmentsystem.model.Technician;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TechnicianRepository extends MongoRepository<Technician,String> {

//    List<Patient> findBySeverity(int severity);
//
//    @Query("{ assignee: ?0 }")
//    List<Patient> getTasksByAssignee(String assignee);
}
