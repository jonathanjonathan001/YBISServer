package com.jonfen.ybisserver.repository;

import com.jonfen.ybisserver.entity.Order;
import com.jonfen.ybisserver.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
