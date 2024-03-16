package com.labappointment.labappointmentsystem.repository;

import com.labappointment.labappointmentsystem.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment,String> {

//    List<Patient> findBySeverity(int severity);
//
//    @Query("{ assignee: ?0 }")
//    List<Patient> getTasksByAssignee(String assignee);
}
