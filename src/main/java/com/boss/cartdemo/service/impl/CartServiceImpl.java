package com.boss.cartdemo.service.impl;

import com.boss.cartdemo.dao.ItemDao;
import com.boss.cartdemo.entity.Item;
import com.boss.cartdemo.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 覃玉锦
 */
@Service("CartService")
@Transactional(rollbackFor = {Exception.class})
@Slf4j
public class CartServiceImpl implements CartService {
    @Autowired
    private ItemDao itemDao;

    @Override
    public boolean updateItem(Item item) {
        itemDao.updateItem(item);
        log.debug("enter service {}", item);
        return true;
    }

    @Override
    public boolean removeItem(Item item) {
        itemDao.removeItem(item.getProductName());
        return true;
    }

    @Override
    public List<Item> queryItems() {
        return itemDao.findAll();
    }

    @Override
    public boolean saveCart(List<Item> items) {
        List<Item> oldItems = itemDao.findAll();
        boolean repeat = false;
        for (Item item : items) {
            repeat = false;
            for (int i = 0; i < oldItems.size(); i++) {
                if (oldItems.get(i).getProductName().equals(item.getProductName())) {
                    repeat = true;
                }
            }

            if (!repeat) {
                itemDao.saveItem(item);
            }
        }
        return false;
    }
}
