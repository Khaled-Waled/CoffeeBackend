package com.test.CoffeeBackend.entity;

import javax.persistence.*;

/**
 * @author khaled-waled
 * A JPA entity to store a user's data
 */
@Entity
@Table(name = "app_users")
public class AppUser
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(name = "full_name")
    private String fullName;

    public AppUser()
    {
    }

    /**
     * @param email User's email
     * @param password User's password
     * @param fullName User's Full name
     */
    public AppUser(String email, String password, String fullName)
    {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    /**
     * Get User's ID
     * @return ID
     */
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }
}

