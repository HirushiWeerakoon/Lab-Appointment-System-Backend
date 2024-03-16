package com.labappointment.labappointmentsystem.controller;

import com.labappointment.labappointmentsystem.model.Test;
import com.labappointment.labappointmentsystem.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tests")
public class TestController {

    @Autowired
    private TestService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Test createTest(@RequestBody Test test){
        return service.addTest(test);
    }

    @GetMapping
    public List<Test> getTest() {
        return service.findAllTest();
    }

    @GetMapping("/{testId}")
    public Test getTest(@PathVariable String testId){
        return service.getTestByTestId(testId);
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
    public Test modifyTest(@RequestBody Test test){
        return service.updateTest(test);
    }

    @DeleteMapping("/{testId}")
    public String deleteTest(@PathVariable String testId){
        return service.deleteTest(testId);
    }
}
