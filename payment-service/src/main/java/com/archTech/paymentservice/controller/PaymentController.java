package com.archTech.paymentservice.controller;
import com.archTech.paymentservice.entity.Payment;
import com.archTech.paymentservice.entity.PaymentBody;
import com.archTech.paymentservice.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.archTech.paymentservice.entity.Order;

@RestController
@RequestMapping("/payments")
@Slf4j
public class PaymentController
{
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/makePayment")
    public Order makePayment(@RequestBody PaymentBody payment) { return paymentService.makePayment(payment); }

    @GetMapping("/{id}")
    public Payment getPaymentWithId(@PathVariable("id") Long paymentId) { return paymentService.findProductById(paymentId); }
}
