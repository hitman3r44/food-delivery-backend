package com.wolverinesolutions.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
class Item {

    private String itemId = new ObjectId().toString();
    private String itemName;
    private double price;  // in dollars
    private String category;
    private boolean isFavorites = false; // default value is false
    private boolean isActive = true; // default value is true. used for soft deletion
    private String description;
    private String image; // image url

}
