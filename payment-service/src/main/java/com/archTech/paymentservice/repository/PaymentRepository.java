package com.archTech.paymentservice.repository;

import com.archTech.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long>
{
    Payment findByPaymentId(Long productId);
}
