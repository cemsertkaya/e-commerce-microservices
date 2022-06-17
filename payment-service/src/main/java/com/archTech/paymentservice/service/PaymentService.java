package com.archTech.paymentservice.service;
import com.archTech.paymentservice.entity.Order;
import com.archTech.paymentservice.entity.Payment;
import com.archTech.paymentservice.entity.PaymentBody;
import com.archTech.paymentservice.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
@Slf4j
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Order makePayment(PaymentBody paymentBody)
    {
        HttpEntity<Order> request = new HttpEntity<>(new Order(paymentBody.getPayment().getUserId(), paymentBody.getAddedProduct()));

        Order order = restTemplate.postForObject("http://localhost:9004/orders/", request, Order.class);

        return  order;
    }

    public Payment findProductById(Long paymentId) {return paymentRepository.findByPaymentId(paymentId);}
}