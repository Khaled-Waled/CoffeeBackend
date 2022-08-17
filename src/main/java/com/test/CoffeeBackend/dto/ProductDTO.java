package com.test.CoffeeBackend.dto;

public class ProductDTO
{
    private String image;
    private String name;
    private float price;

    private String description;

    public ProductDTO(String image, String name, float price, String description)
    {
        this.image = image;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public ProductDTO () {}

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
