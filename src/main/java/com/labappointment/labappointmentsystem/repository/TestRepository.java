package com.labappointment.labappointmentsystem.repository;

import com.labappointment.labappointmentsystem.model.Test;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<Test,String> {

//    List<Patient> findBySeverity(int severity);
//
//    @Query("{ assignee: ?0 }")
//    List<Patient> getTasksByAssignee(String assignee);
}
