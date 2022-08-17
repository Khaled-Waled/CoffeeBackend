package com.test.CoffeeBackend.repository;

import com.test.CoffeeBackend.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface extends a JPA repository that does CRUD operation on the entity User
 */

@Repository
public interface UserRepository extends JpaRepository<AppUser,Integer>
{
    /**
     * Finds and retrieves a user using email
     * @param email target's email
     * @return the resulting user with that email
     */
    AppUser findByEmail(String email);

    /**
     * Checks if a user exists with that email
     * @param email target's email
     * @return ``true`` if it exists, ``false`` if not
     */
    Boolean existsByEmail(String email);

}
