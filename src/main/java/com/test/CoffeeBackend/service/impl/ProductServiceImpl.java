package com.test.CoffeeBackend.service.impl;

import com.test.CoffeeBackend.dto.ProductDTO;
import com.test.CoffeeBackend.entity.Product;
import com.test.CoffeeBackend.repository.ProductRepository;
import com.test.CoffeeBackend.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    ModelMapper modelMapper;
    @Override
    public ResponseEntity<?> createProduct(ProductDTO productDTO)
    {
       Product productEntity =
               new Product(productDTO.getImage(), productDTO.getName(),productDTO.getPrice(), productDTO.getDescription());
       productRepository.save(productEntity);
       URI uri =
               URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().
                       path("/api/products/add").toUriString());
       return ResponseEntity.created(uri).body("saved");
    }

    @Override
    public ResponseEntity<?> getProduct(Long id)
    {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent())
        {
            ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
            return ResponseEntity.ok(productDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> deleteProduct(Long id)
    {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent())
        {
            productRepository.delete(product.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ArrayList<ProductDTO> getAll()
    {
        List<Product> products = productRepository.findAll();
        ArrayList<ProductDTO> productDTOS = new ArrayList<>();

        products.forEach(product ->
                productDTOS.add(modelMapper.map(product,ProductDTO.class)));
        return productDTOS;
    }
}
