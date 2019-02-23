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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Map<OrderStatus, Date> getUpdateHistory() {
        return updateHistory;
    }

    public void setUpdateHistory(Map<OrderStatus, Date> updateHistory) {
        this.updateHistory = updateHistory;
    }

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
