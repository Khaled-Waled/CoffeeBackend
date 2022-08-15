package com.test.CoffeeBackend.repository;

import com.test.CoffeeBackend.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Integer>
{
}
