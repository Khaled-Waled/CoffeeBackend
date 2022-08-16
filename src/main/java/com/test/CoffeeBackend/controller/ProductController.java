package com.test.CoffeeBackend.controller;

import com.test.CoffeeBackend.dto.ProductDTO;
import com.test.CoffeeBackend.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author khaled-waled
 * A Rest controller that provides Create product, get a product, and get all products APIs
 */
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

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id)
    {
        return productService.getProduct(id);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts()
    {
        return ResponseEntity.ok().body(productService.getAll());
    }
}
