package com.test.CoffeeBackend.service.impl;

import com.test.CoffeeBackend.dto.ProductDTO;
import com.test.CoffeeBackend.entity.Product;
import com.test.CoffeeBackend.repository.ProductRepository;
import com.test.CoffeeBackend.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author khaled-waled
 * @since 2022-08-15
 * A JPA-based implementation for adding and managing products
 */
@Service
public class ProductServiceImpl implements IProductService
{
    @Autowired
    ProductRepository productRepository;
    @Override
    public ResponseEntity<?> createProduct(ProductDTO productDTO)
    {
       Product productEntity =
               new Product(productDTO.getImage(), productDTO.getName(),productDTO.getPrice());
       productRepository.save(productEntity);
       URI uri =
               URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().
                       path("/api/products/add").toUriString());
       return ResponseEntity.created(uri).body("saved");
    }

    @Override
    public ResponseEntity<?> getProduct(Long id)
    {
        //TODO
        return null;
    }

    @Override
    public ArrayList<ProductDTO> getAll()
    {
        List<Product> products = productRepository.findAll();
        ArrayList<ProductDTO> productDTOS = new ArrayList<>();

        products.forEach(product ->
                productDTOS.add(new ProductDTO(product.getImage(),product.getName(),product.getPrice())));
        return productDTOS;
    }
}
