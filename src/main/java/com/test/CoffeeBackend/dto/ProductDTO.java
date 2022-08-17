package com.test.CoffeeBackend.dto;

public class ProductDTO
{
    private Long id;
    private String image;
    private String name;
    private float price;

    private String description;

    public ProductDTO(Long id, String image, String name, float price, String description)
    {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public ProductDTO () {}

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
