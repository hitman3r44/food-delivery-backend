package com.wolverinesolutions.controller;

import com.wolverinesolutions.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class OrderCompleteUpdater {

    private static final Logger log = LoggerFactory.getLogger(OrderCompleteUpdater.class);

    @Autowired
    private SimpMessagingTemplate template;

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public void orderComplete(@RequestBody Order order) {

        log.info("Receive order = " + order.toString());

        if (order.getUserInfo().getId() == null) {
            order.getUserInfo().setId("");
        }

        if (order.getPaymentId() == null) {
            order.setPaymentId("");
        }

        if (order.getSpecialNote() == null) {
            order.setSpecialNote("");
        }

        template.convertAndSend("/topic/orders", order);
    }

    @RequestMapping(value = "/errors", method = RequestMethod.POST)
    public void orderComplete(@RequestBody String errorMessage) {

        log.info("Receive error = " + errorMessage);

        template.convertAndSend("/topic/orders", errorMessage);
    }
}
