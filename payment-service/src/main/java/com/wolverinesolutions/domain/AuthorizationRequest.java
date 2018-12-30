package com.wolverinesolutions.domain;

import com.wolverinesolutions.domain.entities.CreditCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class AuthorizationRequest {

    private CreditCard creditCard;
    private double amount;
}
