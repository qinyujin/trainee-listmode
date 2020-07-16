package com.boss.cartdemo.dao;

import com.boss.cartdemo.entity.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * crud都写上，或许有用的地方
 */
@Mapper
public interface ItemDao {

    List<Item> findAll();

    Item getItemById(int id);

    boolean saveItem(Item item);

    boolean updateItem(Item item);

    boolean removeItem(int id);


}
