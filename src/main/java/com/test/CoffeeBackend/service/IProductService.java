package com.test.CoffeeBackend.service;

import com.test.CoffeeBackend.dto.ProductDTO;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public interface IProductService
{
    public ResponseEntity<?> createProduct(ProductDTO productDTO);
    public ResponseEntity<?> getProduct(Long id);
    public ResponseEntity<?> deleteProduct(Long id);

    public ArrayList<ProductDTO> getAll();


}
