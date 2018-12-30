package com.wolverinesolutions.domain;

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
public class DeliveryInfo {

    private static final double DEFAULT_DELIVERY_DISTANCE = 20; // in km

    private Double charge;
    private Double maxDeliveryDistance; // only delivery to location within some, say 10km, distance.
    private String averageDeliveryTime;

    public DeliveryInfo(double charge) {
        this.charge = charge;
    }

    public DeliveryInfo(double charge, double maxDeliveryDistance) {
        this.charge = charge;
        this.maxDeliveryDistance = maxDeliveryDistance;
    }
}
