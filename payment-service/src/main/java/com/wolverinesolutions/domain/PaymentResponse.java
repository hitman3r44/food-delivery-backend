package com.wolverinesolutions.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class PaymentResponse {

    private String paymentId;
    private String orderId;
    private boolean isApproved;
    private boolean isTimeout;
    private String message;
    private int deliveryTime;

    public PaymentResponse(String paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentResponse(@JsonProperty("paymentId") String paymentId,
                           @JsonProperty("orderId") String orderId,
                           @JsonProperty("isApproved") boolean isApproved,
                           @JsonProperty("isTimeout") boolean isTimeout,
                           @JsonProperty("message") String message) {

        this.paymentId = paymentId;
        this.orderId = orderId;
        this.setApproved(isApproved);
        this.isTimeout = isTimeout;
        this.message = message;

        if (this.isApproved())
            this.deliveryTime = getRandomDeliveryTime(5, 60);
    }

    // generate random number in the range of [5, 60]
    private int getRandomDeliveryTime(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    public void setRandomDeliveryTime(int min, int max) {
        this.deliveryTime = getRandomDeliveryTime(min, max);
    }
}
