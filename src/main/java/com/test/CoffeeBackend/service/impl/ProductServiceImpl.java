package com.test.CoffeeBackend.service.impl;

import com.test.CoffeeBackend.dto.ProductDTO;
import com.test.CoffeeBackend.service.IProductService;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public class ProductServiceImpl implements IProductService
{
    @Override
    public ResponseEntity<?> createProduct(ProductDTO productDTO)
    {
        return null;
    }

    @Override
    public ResponseEntity<?> getProduct(Long id)
    {
        return null;
    }

    @Override
    public ArrayList<ProductDTO> getAll()
    {
        return null;
    }
}
