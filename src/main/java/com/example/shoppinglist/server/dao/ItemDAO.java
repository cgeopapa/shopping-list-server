package com.example.shoppinglist.server.dao;

import com.example.shoppinglist.server.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDAO extends JpaRepository<Item, Long>
{

}
