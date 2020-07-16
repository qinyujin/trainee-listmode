package com.boss.cartdemo.service;

import com.boss.cartdemo.entity.Item;

import java.util.List;

public interface CartService {
    boolean addItem(Item item);
    boolean removeItem(String productName);
    List<Item> queryItems();
    boolean saveCart(List<Item> items);
}