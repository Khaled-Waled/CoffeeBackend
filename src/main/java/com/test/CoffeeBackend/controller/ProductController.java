package com.test.CoffeeBackend.controller;

import com.test.CoffeeBackend.dto.AuthRequestDTO;
import com.test.CoffeeBackend.dto.ProductDTO;
import com.test.CoffeeBackend.entity.Product;
import com.test.CoffeeBackend.repository.ProductRepository;
import com.test.CoffeeBackend.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController
{
    @Autowired
    IProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> addNewProduct(@RequestBody ProductDTO productDTO)
    {
        return productService.createProduct(productDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts()
    {
        return ResponseEntity.ok().body(productService.getAll());
    }
}
