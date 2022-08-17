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
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController
{
    @Autowired
    IProductService productService;

    /**
     * An API end point to add a product
     * @param productDTO carries the data representing a product
     * @return the status of the request
     */
    @PostMapping("/add")
    public ResponseEntity<?> addNewProduct(@RequestBody ProductDTO productDTO)
    {
        return productService.createProduct(productDTO);
    }

    /**
     * An API end point to retrieve a product by its ID
     * @param id ID of the product
     * @return the desired product
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id)
    {
        return productService.getProduct(id);
    }

    /**
     * An API end point to retrieve all products stored in the system
     * @return List of products
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts()
    {
        return ResponseEntity.ok().body(productService.getAll());
    }

    /**
     * An API end point to delete a product by its ID
     * @param id ID of the product
     * @return the status of the request
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id)
    {
        return productService.deleteProduct(id);
    }
}
