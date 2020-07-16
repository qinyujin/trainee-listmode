package com.boss.cartdemo.entity;

import java.util.HashMap;

public class Cart {
    private  HashMap<String,Item> items;

    public HashMap<String, Item> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Item> items) {
        this.items = items;
    }

    private static Cart instance = new Cart();

    private Cart(){};

 public static Cart getInstance(){
     return instance;
 }
}
