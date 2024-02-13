package com.jonfen.ybisserver.repository;

import com.jonfen.ybisserver.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
