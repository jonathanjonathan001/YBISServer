package com.jonfen.ybisserver.service;

import com.jonfen.ybisserver.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product modifyProduct(Product product);

}
