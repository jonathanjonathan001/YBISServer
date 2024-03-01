package com.jonfen.ybisserver.repository;

import com.jonfen.ybisserver.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLinesRepository extends JpaRepository<OrderLine, Long> {
}
