package com.boss.cartdemo.controller;

import com.boss.cartdemo.entity.Item;
import com.boss.cartdemo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author 覃玉锦
 * 控制层，用于接收请求返回数据
 */
@RestController
@RequestMapping("/Cart")
public class CartController {
    @Autowired
    private CartService cartService;

    private static final String CART = "cart";
    private static final int INIT_OPACITY = 16;

    /**
     * 将item添加至cart里，并且把cart存入session里
     *
     * @param request
     * @param item
     * @return
     */
    @PostMapping("/addItem")
    public Map addItem(HttpServletRequest request, @RequestBody Item item) {
        Map<String, Item> map = (Map<String, Item>) request.getSession().getAttribute(CART);
        if (map == null) {
            map = new HashMap(INIT_OPACITY);
        }
        map.put(item.getProductName(), item);
        request.getSession().setAttribute("cart", map);
        return map;
    }

    /**
     * 把item从cart中移除
     *
     * @param request
     * @param item
     * @return
     */
    @PostMapping("/removeItem")
    public Map removeItem(HttpServletRequest request, @RequestBody Item item) {
        Map<String, Item> map = (Map<String, Item>) request.getSession().getAttribute(CART);
        map.remove(item.getProductName());
        request.getSession().setAttribute("cart", map);
        return map;
    }

    /**
     * 查询当前cart
     *
     * @param request
     * @return
     */
    @GetMapping("/queryCart")
    public Map queryCart(HttpServletRequest request) {
       return (Map<String, Item>) request.getSession().getAttribute(CART);
    }

    /**
     * 将cart数据存入数据库
     *
     * @param request
     * @return
     */
    @GetMapping("/saveCart")
    public Map saveCart(HttpServletRequest request) {
        Map<String, Item> map = (Map<String, Item>) request.getSession().getAttribute(CART);
        String message = "没有任何选项可以提交";
        if (map == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
        }
        Collection<Item> values = map.values();

        List<Item> list = new ArrayList<>();
        for (Item value : values) {
            list.add(value);
        }

        cartService.saveCart(list);
        return map;
    }

    /**
     * 对数据库中的items查询
     *
     * @return
     */
    @GetMapping("/querySavedCart")
    public Map querySavedCart() {
        List<Item> list = cartService.queryItems();
        Map<String, List<Item>> map = new HashMap<>(INIT_OPACITY);
        map.put("SavedCart", list);
        return map;
    }

    /**
     * 根据name删除数据库中的item
     *
     * @param item
     */
    @PostMapping("/removeSavedItem")
    public void removeSavedItem(@RequestBody Item item) {
        cartService.removeItem(item);
    }

    /**
     * 更新数据库item
     * @param item
     */
    @PatchMapping("/updateSavedItem")
    public void updateSavedItem(@RequestBody Item item) {
        cartService.updateItem(item);
    }


}
