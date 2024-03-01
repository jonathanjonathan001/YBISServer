package com.jonfen.ybisserver.service;

import com.jonfen.ybisserver.entity.Order;
import com.jonfen.ybisserver.entity.OrderLine;
import com.jonfen.ybisserver.repository.OrderLinesRepository;
import com.jonfen.ybisserver.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    OrderLinesRepository orderLinesRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderLinesRepository orderLinesRepository) {
        this.orderRepository = orderRepository;
        this.orderLinesRepository = orderLinesRepository;
    }



    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public OrderLine createOrderLine(OrderLine orderLine) {
        return orderLinesRepository.save(orderLine);
    }
}
