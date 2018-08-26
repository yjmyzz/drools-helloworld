package com.cnblogs.yjmyzz.drools.demo.model;

import lombok.Data;

@Data
public class CartItem {
    private Cart cart;
    private Product product;
    private int qty;
    private boolean errors;
    private String error;
    private CartStatus cartStatus;

    public CartItem(Cart cart, Product product, int qty) {
        this.cart = cart;
        this.product = product;
        this.qty = qty;
        cartStatus = CartStatus.NEW;
    }

    @Override
    public String toString() {
        return product + ", 数量: " + qty + ", 是否有问题？ " + isErrors() + (isErrors() ? ", 问题描述: " + getError() : "");
    }

    public void updateAsProcessed() {
        cartStatus = CartStatus.PROCESSED;
    }

}
