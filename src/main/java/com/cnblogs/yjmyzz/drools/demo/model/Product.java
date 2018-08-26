package com.cnblogs.yjmyzz.drools.demo.model;

import lombok.Data;

/**
 * @author jimmy
 */
@Data
public class Product {
    private int price;
    private String desc;
    private int availableQty = 5;
    private boolean requiresRegistration;
    private boolean isOutOfStock;

    public Product(String desc, int price) {
        this.desc = desc;
        this.price = price;
    }


    @Override
    public String toString() {
        return desc + ", 价格: " + price;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        Product p = (Product) o;
        return getDesc().equals(p.getDesc());
    }

    @Override
    public int hashCode() {
        return getDesc().hashCode();
    }
}

