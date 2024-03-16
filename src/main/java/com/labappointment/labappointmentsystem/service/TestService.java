package com.labappointment.labappointmentsystem.service;

import com.labappointment.labappointmentsystem.model.Test;
import com.labappointment.labappointmentsystem.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TestService {

    @Autowired
    private TestRepository repository;

    //CRUD  CREATE , READ , UPDATE , DELETE


    public Test addTest(Test test) {
        test.setTestId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(test);
    }

    public List<Test> findAllTest() {
        return repository.findAll();
    }

    public Test getTestByTestId(String testId){
        return repository.findById(testId).get();
    }

//    public List<Task> getTaskBySeverity(int severity){
//        return  repository.findBySeverity(severity);
//    }
//
//    public List<Task> getTaskByAssignee(String assignee){
//        return repository.getTasksByAssignee(assignee);
//    }

    public Test updateTest(Test testRequest){
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        Test existingTest = repository.findById(testRequest.getTestId()).get();
        existingTest.setName(testRequest.getName());
        existingTest.setDetail(testRequest.getDetail());
        return repository.save(testRequest);
    }

    public String deleteTest(String testId){
        repository.deleteById(testId);
        return testId+" test deleted from dashboard ";
    }
}
