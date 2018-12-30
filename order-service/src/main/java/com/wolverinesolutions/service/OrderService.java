package com.wolverinesolutions.service;


import com.wolverinesolutions.domain.OrderStatusUpdateMessage;
import com.wolverinesolutions.domain.entities.Order;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface OrderService {

    Order findByOrderId(String orderId);

    List<Order> findByUserId(Sort sort, String userId);

    Order saveOrder(Order order);

    void updateOrderStatus(String orderId, OrderStatusUpdateMessage orderStatusUpdateMessage);

}
