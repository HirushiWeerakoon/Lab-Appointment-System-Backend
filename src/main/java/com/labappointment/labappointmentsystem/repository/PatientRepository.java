package com.labappointment.labappointmentsystem.repository;

import com.labappointment.labappointmentsystem.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PatientRepository extends MongoRepository<Patient,String> {

//    List<Patient> findBySeverity(int severity);
//
//    @Query("{ assignee: ?0 }")
//    List<Patient> getTasksByAssignee(String assignee);
}
