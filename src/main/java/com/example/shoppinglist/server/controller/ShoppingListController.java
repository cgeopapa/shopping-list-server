package com.example.shoppinglist.server.controller;

import com.example.shoppinglist.server.dao.ItemDAO;
import com.example.shoppinglist.server.model.Item;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ShoppingListController
{
    @Autowired
    private ItemDAO itemDAO;

    @GetMapping
    public List<Item> findAll()
    {
        return itemDAO.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Item save(@Valid @NotNull Item item)
    {
        return itemDAO.save(item);
    }
    
    @PutMapping
    public void update(@Valid @NotNull @RequestBody List<Item> items)
    {
        for (Item item: items)
        {
            itemDAO.save(item);
        }
    }

    @DeleteMapping
    public void delete(@Valid @NotNull @RequestBody List<Item> items)
    {
        for (Item item: items)
        {
            itemDAO.deleteById(item.getId());
        }
    }
}
