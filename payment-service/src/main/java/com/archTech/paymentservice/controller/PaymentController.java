package com.archTech.paymentservice.controller;


import com.archTech.paymentservice.entity.Payment;
import com.archTech.paymentservice.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@Slf4j
public class PaymentController
{
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/")
    public Payment saveProduct(@RequestBody Payment payment)
    {
        log.info("Inside saveProduct of productController");
        return paymentService.makePayment(payment);
    }

    @GetMapping("/{id}")
    public Payment getPaymentWithId(@PathVariable("id") Long paymentId)
    {
        return paymentService.findProductById(paymentId);
    }
}
