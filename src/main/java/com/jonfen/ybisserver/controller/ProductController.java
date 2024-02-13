package com.jonfen.ybisserver.controller;

import com.jonfen.ybisserver.entity.Product;
import com.jonfen.ybisserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ProductController {

    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<Product> getProducts() { return service.findAll(); }

    @GetMapping("/product/{productId}")
    public Optional<Product> findProductById(@PathVariable Long productId) {
        return service.findById(productId);
    }

    @PutMapping("/product/{productId}")
    public void updateStock(@PathVariable Long productId, @RequestBody Product productInput) {

        Optional<Product> productToUpdate = service.findById(productId);
        if (productToUpdate.isPresent()) {
            productToUpdate.get().setStock(productInput.getStock());
            service.modifyProduct(productToUpdate.get());
        }

    }







}
