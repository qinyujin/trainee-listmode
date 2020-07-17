package com.boss.cartdemo.service;

import com.boss.cartdemo.entity.Item;

import java.util.List;

/**
 * @author 覃玉锦
 */
public interface CartService {
    /**
     * 删
     * @param item
     * @return
     */
    boolean removeItem(Item item);

    /**
     * 查全部
     * @return
     */
    List<Item> queryItems();

    /**
     * 增
     * @param items
     * @return
     */
    boolean saveCart(List<Item> items);

    /**
     * 改
     * @param item
     * @return
     */
    boolean updateItem(Item item);
}