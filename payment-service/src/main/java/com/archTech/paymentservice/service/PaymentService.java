package com.archTech.paymentservice.service;


import com.archTech.paymentservice.entity.Payment;
import com.archTech.paymentservice.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Payment makePayment(Payment payment)
    {
        return  paymentRepository.save(payment);
    }

    public Payment findProductById(Long paymentId) {return paymentRepository.findByPaymentId(paymentId);}
}