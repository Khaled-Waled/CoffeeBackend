package com.test.CoffeeBackend.repository;

import com.test.CoffeeBackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>
{
}
