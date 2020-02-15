package com.example.shoppinglist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Item
{
    private long id;
    @NotBlank
    private String name;
    private boolean bought = false;

    public Item()
    {
    }

    public Item(long id, @NotBlank String name, boolean bought)
    {
        this.id = id;
        this.name = name;
        this.bought = bought;
    }

    @Id
    @GeneratedValue
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isBought()
    {
        return bought;
    }

    public void setBought(boolean bought)
    {
        this.bought = bought;
    }
}
