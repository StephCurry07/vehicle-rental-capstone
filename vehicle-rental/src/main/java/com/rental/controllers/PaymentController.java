package com.rental.controllers;

import com.rental.entity.Payment;
import com.rental.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable("id") String id) {
        return paymentService.getPaymentById(id);
    }

    @PostMapping
    public Payment processPayment(@RequestBody Payment payment) {
        return paymentService.processPayment(payment);
    }
}
