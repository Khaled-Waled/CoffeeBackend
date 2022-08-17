package com.test.CoffeeBackend.repository;

import com.test.CoffeeBackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface extends a JPA repository that does CRUD operation on the entity Product
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
}
