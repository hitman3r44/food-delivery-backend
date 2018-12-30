package com.wolverinesolutions.domain;

import com.wolverinesolutions.domain.entities.OrderStatus;
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
public class OrderStatusUpdateMessage {

    private String paymentId;
    private OrderStatus orderStatus;

    @Override
    public String toString() {
        return "OrderStatusUpdateMessage{" +
                "paymentId='" + paymentId + '\'' +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
