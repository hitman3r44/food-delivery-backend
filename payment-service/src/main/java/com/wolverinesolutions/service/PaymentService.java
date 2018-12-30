package com.wolverinesolutions.service;

import com.wolverinesolutions.domain.AuthorizationResponse;
import com.wolverinesolutions.domain.OrderStatusUpdateMessage;
import com.wolverinesolutions.domain.entities.Payment;
import org.springframework.util.concurrent.ListenableFuture;

public interface PaymentService {

    Payment savePayment(Payment payment);

    ListenableFuture<AuthorizationResponse> makePayment(Payment payment);

    void updateOrderStatusAfterPayment(String orderId, OrderStatusUpdateMessage orderStatusUpdate);

    Payment getPaymentById(String paymentId);

    Payment getPaymentByOrderId(String orderId);
}
