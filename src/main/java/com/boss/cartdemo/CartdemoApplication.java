package com.boss.cartdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 覃玉锦
 */
@SpringBootApplication
@MapperScan("com.boss.cartdemo.dao")
public class CartdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartdemoApplication.class, args);
    }

}
