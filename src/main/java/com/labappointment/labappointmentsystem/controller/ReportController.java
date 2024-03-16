package com.labappointment.labappointmentsystem.controller;

import com.labappointment.labappointmentsystem.model.Report;
import com.labappointment.labappointmentsystem.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Report createReport(@RequestBody Report report){
        return service.addReport(report);
    }

    @GetMapping
    public List<Report> getReport() {
        return service.findAllReport();
    }

    @GetMapping("/{reportId}")
    public Report getReport(@PathVariable String reportId){
        return service.getReportByReportId(reportId);
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
    public Report modifyReport(@RequestBody Report report){
        return service.updateReport(report);
    }

    @DeleteMapping("/{reportId}")
    public String deleteReport(@PathVariable String reportId){
        return service.deleteReport(reportId);
    }
}
