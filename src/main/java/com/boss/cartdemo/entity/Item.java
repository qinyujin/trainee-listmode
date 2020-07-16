package com.boss.cartdemo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 覃玉锦
 * 购物车的每一数据项
 * 属性：品名、规格型号、数量、用途地点、需要时间
 */
@Data
public class Item implements Serializable {

    private int id;
    private String productName;
    private String specification;
    private int count;
    private String usingPlace;
    private float needTime;

}
