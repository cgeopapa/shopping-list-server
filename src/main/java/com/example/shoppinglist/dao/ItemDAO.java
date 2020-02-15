package com.example.shoppinglist.dao;

import com.example.shoppinglist.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDAO extends JpaRepository<Item, Long>
{

}
