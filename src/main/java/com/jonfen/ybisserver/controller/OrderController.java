package com.jonfen.ybisserver.controller;

import com.jonfen.ybisserver.entity.Order;
import com.jonfen.ybisserver.entity.OrderLine;
import com.jonfen.ybisserver.entity.Product;
import com.jonfen.ybisserver.service.OrderService;
import com.jonfen.ybisserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class OrderController {

    private OrderService orderService;
    private ProductService productService;

    @Autowired
    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }


    @GetMapping("/orders/{orderId}")
    public Optional<Order> getOrderById(@PathVariable Long orderId) {
        return orderService.findById(orderId);
    }

    @GetMapping("/orders")
    public List<Order> getOrders() { return orderService.findAll(); }

    @PostMapping("/orderlines/{orderId}/{productId}")
    public OrderLine createOrderLine(@RequestBody OrderLine orderLine, @PathVariable Long orderId, @PathVariable Long productId) {
        Optional<Order> theOrder = orderService.findById(orderId);
        Optional<Product> theProduct = productService.findById(productId);

        if (theOrder.isPresent()) {
            orderLine.setOrder(theOrder.get());
        }

        if (theProduct.isPresent()) {
            orderLine.setProduct(theProduct.get());
        }

        return orderService.createOrderLine(orderLine);
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        // Set id to 0 just in case POST request handed down an id
        order.setId(0L);


        return orderService.createOrder(order);

//        for (OrderLines orderLine : order.getOrderLines()) {
//
//            order.getOrderLines().add(new OrderLines(newOrder, orderLine.getProduct()));
//        }

        // newOrder.getId()

//        for (OrderLines orderLine : newOrder.getOrderLines()) {
//
//            orderLine.getOrder().setId(order.getId());
//        }

//        for (OrderLines orderLine : order.getOrderLines()) {
//            orderLine.getProduct().setId orderLine.getProduct().getId()
//        }



        // service.createOrderLines(order.getOrderLines());


    }

}
