package com.wolverinesolutions.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Document(collection = "restaurants")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Restaurant {

    @Id
    private String id;
    @Indexed
    private String restaurantName;
    private List<Item> items = new ArrayList<>();

    // TODO: Finish this class
    // add location and deliveryInfo

   /* @GeoSpatialIndexed
    private Point location;
    private Address address;
    private String description;
    private DeliveryInfo deliveryInfo;
    private String phoneNumber;
    private String image; // image url*/

    // need to add hours (date, open time, closing time)
    // so that we can determine if the restaurant accepts delivery now.

    @JsonCreator
    public Restaurant(@JsonProperty("restaurantName") String restaurantName,
                      @JsonProperty("items") List<Item> items) {
        this.restaurantName = restaurantName;
        this.items = items;
    }
}
