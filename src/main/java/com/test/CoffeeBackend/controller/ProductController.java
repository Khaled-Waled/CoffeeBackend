package com.test.CoffeeBackend.controller;

import com.test.CoffeeBackend.dto.AuthRequestDTO;
import com.test.CoffeeBackend.dto.ProductDTO;
import com.test.CoffeeBackend.entity.Product;
import com.test.CoffeeBackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController
{
    @Autowired
    ProductRepository productRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addNewProduct(@RequestBody ProductDTO productDTO)
    {
        Product productEntity = new Product(productDTO.getImage(), productDTO.getName(),productDTO.getPrice());
        productRepository.save(productEntity);
        return null;
    }
}
