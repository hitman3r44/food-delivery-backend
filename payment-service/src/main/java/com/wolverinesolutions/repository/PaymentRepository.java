package com.wolverinesolutions.repository;

import com.wolverinesolutions.domain.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepository extends JpaRepository<Payment, String> {

    Payment findByOrderId(String orderId);
}
