package com.test.CoffeeBackend.entity;

import javax.persistence.*;

/**
 * A JPA entity to store a user's data
 *
 * @author khaled-waled
 */
@Entity
@Table(name = "products")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "image")
    private String image;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "description")
    private String description;

    /**
     * Default Constructor
     */
    public Product()
    {
    }

    /**
     * Parametrised Constructor for the entity
     * @param image Image URL
     * @param name  Product's Name
     * @param price Product's Price
     * @param description   Product's Description
     */
    public Product(String image, String name, float price, String description)
    {
        this.image = image;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    /**
     * Setters and getters
     */
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
