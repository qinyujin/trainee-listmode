package com.boss.cartdemo;

import com.boss.cartdemo.dao.ItemDao;
import com.boss.cartdemo.entity.Item;
import com.boss.cartdemo.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
@Slf4j
class CartdemoApplicationTests {

    @Autowired
    private ItemDao itemDao;
    @Autowired
    private CartService cartService;

    @Test
    void contextLoads() {
        System.out.println(itemDao.findAll());
    }

    @Test
    public void TestGetById(){
        System.out.println(itemDao.getItemById(1));
    }

    @Test
    public void TestInsert(){
        Item item = new Item();

        item.setProductName("Mi");
        item.setCount(40);
        item.setSpecification("15");
        item.setUsingPlace("Game");
        item.setNeedTime(24);
        System.out.println(itemDao.saveItem(item));
    }

    @Test
    public void TestInsertAll(){
        Item i1 = new Item();
        i1.setProductName("Honor");
        i1.setSpecification("12");
        i1.setUsingPlace("America");
        i1.setNeedTime(24);
        i1.setCount(9);

        Item i2 = new Item();
        i2.setProductName("Honor pro");
        i2.setSpecification("12");
        i2.setUsingPlace("America");
        i2.setNeedTime(24);
        i2.setCount(9);

        List list = new ArrayList();
        list.add(i1);
        list.add(i2);

        itemDao.saveItemList(list);
    }

    @Test
    public void TestUpdate(){
        Item item = new Item();

        item.setId(9);
        item.setProductName("Honor");
        item.setCount(99);
        item.setNeedTime(12);
        item.setUsingPlace("China");
        item.setSpecification("10");
        System.out.println(itemDao.updateItem(item));
    }

    @Test
    public void TestDelete(){
        System.out.println(itemDao.removeItem("Redmi"));
    }

//    @Test
//    public void TestSingleton(){
////        HashMap<String, Item> items = Cart.getInstance().getItems();
//
//        List<Item> all = itemDao.findAll();
//
//        for (Item item : all) {
//            items.put(item.getProductName(), item);
//        }
//
//        Set<Map.Entry<String, Item>> entries = items.entrySet();
//
//        Iterator<Map.Entry<String, Item>> iterator = entries.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//    }

    @Test
    public void TestCartService(){
        List<Item> all = itemDao.findAll();
//        cartService.addItem(all.get(1));
//        cartService.addItem(all.get(0));

//        System.out.println(Cart.getInstance().getItems().get("Mi"));
//        System.out.println(Cart.getInstance().getItems().get("Mi"));


    }


}
