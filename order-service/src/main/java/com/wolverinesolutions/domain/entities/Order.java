package com.wolverinesolutions.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wolverinesolutions.domain.DeliveryInfo;
import com.wolverinesolutions.domain.Item;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document(collection = "orders")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Order {

    @Id
    private String id;
    @Indexed
    private String userId;
    private String paymentId;

    private OrderStatus orderStatus;
    private List<Item> items = new ArrayList<Item>();
    private DeliveryInfo deliveryInfo;
    private double totalCost;
    private String note;
    @CreatedDate
    private Date creationTime;
    @LastModifiedDate
    private Date lastModifyTime;
    private Map<OrderStatus, Date> updateHistory = new HashMap<OrderStatus, Date>();

    @JsonCreator
    public Order(@JsonProperty("items") List<Item> items,
                 @JsonProperty("deliveryInfo") DeliveryInfo deliveryInfo,
                 @JsonProperty("note") String note) {

        this.setId(getId());
        this.setItems(items);
        this.setDeliveryInfo(deliveryInfo);
        this.setNote(note);
        this.setCreationTime(new Date());
        this.setTotalCost(calculateTotalCost(this.getItems()));
        this.setOrderStatus(OrderStatus.PENDING);
        this.getUpdateHistory().put(this.getOrderStatus(), this.getCreationTime());
    }

    @Getter
    @Setter
    private double calculateTotalCost(List<Item> items) {
        double cost = 0L;
        for (Item item : items) {
            cost += item.getPrice() * 100;
        }
        return cost / 100.0;
    }
}
