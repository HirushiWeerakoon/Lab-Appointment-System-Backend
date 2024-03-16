package com.labappointment.labappointmentsystem.service;

import com.labappointment.labappointmentsystem.model.Report;
import com.labappointment.labappointmentsystem.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReportService {

    @Autowired
    private ReportRepository repository;

    //CRUD  CREATE , READ , UPDATE , DELETE


    public Report addReport(Report report) {
        report.setReportId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(report);
    }

    public List<Report> findAllReport() {
        return repository.findAll();
    }

    public Report getReportByReportId(String reportId){
        return repository.findById(reportId).get();
    }

//    public List<Task> getTaskBySeverity(int severity){
//        return  repository.findBySeverity(severity);
//    }
//
//    public List<Task> getTaskByAssignee(String assignee){
//        return repository.getTasksByAssignee(assignee);
//    }

    public Report updateReport(Report reportRequest){
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        Report existingReport = repository.findById(reportRequest.getReportId()).get();
        existingReport.setDate(reportRequest.getDate());
        existingReport.setTime(reportRequest.getTime());
        return repository.save(reportRequest);
    }

    public String deleteReport(String reportId){
        repository.deleteById(reportId);
        return reportId+" report deleted from dashboard ";
    }
}
