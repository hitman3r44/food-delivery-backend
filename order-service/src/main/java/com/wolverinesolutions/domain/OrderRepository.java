package com.wolverinesolutions.domain;

import com.wolverinesolutions.domain.entities.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, String> {

    Optional<Order> findById(String orderId);

    List<Order> findByUserId(Sort sort, String userId);

}
