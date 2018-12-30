package com.wolverinesolutions.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Item {

    private String itemName;
    private String itemId;
    private int quantity;
    private double price; // price is quantity * unitPrice

    @JsonCreator
    public Item(@JsonProperty("itemName") String itemName,
                @JsonProperty("itemId") String itemId,
                @JsonProperty("quantity") int quantity,
                @JsonProperty("price") double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }
}
