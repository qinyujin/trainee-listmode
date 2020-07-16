package com.boss.cartdemo.service.Impl;

import com.boss.cartdemo.dao.ItemDao;
import com.boss.cartdemo.entity.Item;
import com.boss.cartdemo.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CartService")
@Slf4j
public class CartServiceImpl implements CartService {
    @Autowired
    private ItemDao itemDao;


    @Override
    public boolean addItem(Item item) {
//        items.put(item.getNeedTime(), item);
//        System.out.println(Cart.getInstance().hashCode());
        return true;
    }

    @Override
    public boolean removeItem(String productName) {
//        items.remove(productName);
        return true;
    }

    @Override
    public List<Item> queryItems() {
        List<Item> all = itemDao.findAll();
        return all;
    }

    @Override
    public boolean saveCart(List<Item> items) {
        for (Item item : items) {
            itemDao.saveItem(item);
        }
        return false;
    }
}
