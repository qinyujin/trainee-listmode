package com.boss.cartdemo.dao;

import com.boss.cartdemo.entity.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 覃玉锦
 * crud都写上，或许有用的地方
 */
@Mapper
public interface ItemDao {

    /**
     * 查询所有数据库中的items
     * @return
     */
    List<Item> findAll();

    /**
     * 通过id查询单个item
     * @param id
     * @return
     */
    Item getItemById(int id);

    /**
     * 把item存入数据库
     * @param item
     * @return
     */
    boolean saveItem(Item item);

    /**
     * 更新item的值
     * @param item
     * @return
     */
    boolean updateItem(Item item);

    /**
     * 移除item
     * @param name
     * @return
     */
    boolean removeItem(String name);


}
