package com.example.shoppinglist.server.controller;

import com.example.shoppinglist.server.dao.ItemDAO;
import com.example.shoppinglist.server.model.Item;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class ShoppingListController
{
    @Autowired
    private ItemDAO itemDAO;

    @GetMapping
    public List<Item> findAll()
    {
        return itemDAO.findAll();
    }

    @PostMapping
    public Item save(@Valid @NotNull @RequestBody Item item)
    {
        return itemDAO.save(item);
    }
}
