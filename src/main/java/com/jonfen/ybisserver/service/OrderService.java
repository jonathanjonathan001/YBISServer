package com.jonfen.ybisserver.service;

import com.jonfen.ybisserver.entity.Order;
import com.jonfen.ybisserver.entity.OrderLine;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAll();

    Optional<Order> findById(Long id);

    Order createOrder(Order order);

    OrderLine createOrderLine(OrderLine orderLine);

}
