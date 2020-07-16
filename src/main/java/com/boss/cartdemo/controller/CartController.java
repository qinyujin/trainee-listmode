package com.boss.cartdemo.controller;

import com.boss.cartdemo.entity.Item;
import com.boss.cartdemo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/Cart")
public class CartController {
    @Autowired
    private CartService cartService;

    /**
     * 将item添加至session里
     * @param request
     * @param item
     * @return
     */
    @PostMapping("/addItem")
    public Map addItem(HttpServletRequest request,@RequestBody Item item) {
        Map<String, Item> map = (Map<String, Item>) request.getSession().getAttribute("cart");
        if(map == null) map=new HashMap<String, Item>();
            map.put(item.getProductName(), item);
            request.getSession().setAttribute("cart", map);
            return map;
    }

    @PostMapping("/removeItem")
    public Map removeItem(HttpServletRequest request,@RequestBody Item item){
        Map<String,Item> map = (Map<String, Item>) request.getSession().getAttribute("cart");
        map.remove(item.getProductName());
        request.getSession().setAttribute("cart", map);
        return map;
    }

    @GetMapping("/queryCart")
    public Map queryCart(HttpServletRequest request){
        Map<String,Item> map = (Map<String, Item>) request.getSession().getAttribute("cart");
         return map;
    }

    @GetMapping("/saveCart")
    public Map  saveCart(HttpServletRequest request)  {
        Map<String,Item> map = (Map<String, Item>) request.getSession().getAttribute("cart");
        if(map==null)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"没有任何选项可以提交");
        Collection<Item> values = map.values();

        List<Item> list = new ArrayList<>();
        for (Item value : values) {
            list.add(value);
        }

        cartService.saveCart(list);
        return map;
    }


}
