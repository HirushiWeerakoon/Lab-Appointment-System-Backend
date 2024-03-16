package com.labappointment.labappointmentsystem.controller;

import com.labappointment.labappointmentsystem.model.Payment;
import com.labappointment.labappointmentsystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Payment createPayment(@RequestBody Payment payment){
        return service.addPayment(payment);
    }

    @GetMapping
    public List<Payment> getPayment() {
        return service.findAllPayment();
    }

    @GetMapping("/{paymentId}")
    public Payment getPayment(@PathVariable String paymentId){
        return service.getPaymentByPaymentId(paymentId);
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
    public Payment modifyPayment(@RequestBody Payment payment){
        return service.updatePayment(payment);
    }

    @DeleteMapping("/{paymentId}")
    public String deletePayment(@PathVariable String paymentId){
        return service.deletePayment(paymentId);
    }
}
