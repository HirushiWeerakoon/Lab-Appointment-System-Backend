package com.labappointment.labappointmentsystem.service;

import com.labappointment.labappointmentsystem.model.Payment;
import com.labappointment.labappointmentsystem.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    //CRUD  CREATE , READ , UPDATE , DELETE


    public Payment addPayment(Payment payment) {
        payment.setPaymentId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(payment);
    }

    public List<Payment> findAllPayment() {
        return repository.findAll();
    }

    public Payment getPaymentByPaymentId(String paymentId){
        return repository.findById(paymentId).get();
    }

//    public List<Task> getTaskBySeverity(int severity){
//        return  repository.findBySeverity(severity);
//    }
//
//    public List<Task> getTaskByAssignee(String assignee){
//        return repository.getTasksByAssignee(assignee);
//    }

    public Payment updatePayment(Payment paymentRequest){
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        Payment existingPayment = repository.findById(paymentRequest.getPaymentId()).get();
        existingPayment.setAmount(paymentRequest.getAmount());
        existingPayment.setAppointmentId(paymentRequest.getAppointmentId());
        existingPayment.setCsv(paymentRequest.getCsv());
        existingPayment.setCardNumber(paymentRequest.getCardNumber());
        existingPayment.setExpDate(paymentRequest.getExpDate());
        return repository.save(paymentRequest);
    }

    public String deletePayment(String paymentId){
        repository.deleteById(paymentId);
        return paymentId+" payment deleted from dashboard ";
    }
}
