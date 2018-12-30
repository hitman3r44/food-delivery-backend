package com.wolverinesolutions.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wolverinesolutions.domain.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Payment {

    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne(targetEntity = CreditCard.class, cascade = CascadeType.ALL)
    private CreditCard creditCard;
    private String orderId;
    private double amount;  // in dollars
    private PaymentStatus paymentStatus;

    @JsonCreator
    public Payment(@JsonProperty("orderId") String orderId,
                   @JsonProperty("creditCard") CreditCard creditCard,
                   @JsonProperty("amount") double amount) {
        this.orderId = orderId;
        this.creditCard = creditCard;
        this.amount = amount;
        this.paymentStatus = PaymentStatus.PENDING;
    }
}
