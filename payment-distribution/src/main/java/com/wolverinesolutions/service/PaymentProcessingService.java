package com.wolverinesolutions.service;


import com.wolverinesolutions.domain.AuthorizationRequest;
import com.wolverinesolutions.domain.AuthorizationResponse;

public interface PaymentProcessingService {

    AuthorizationResponse processPayment(AuthorizationRequest request) throws InterruptedException;
}
