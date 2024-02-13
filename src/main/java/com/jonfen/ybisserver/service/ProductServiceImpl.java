package com.jonfen.ybisserver.service;

import com.jonfen.ybisserver.entity.Product;
import com.jonfen.ybisserver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() { return repository.findAll(); }

    @Override
    public Optional<Product> findById(Long id) { return repository.findById(id); }

    @Override
    public Product modifyProduct(Product product) { return repository.save(product); }
}
