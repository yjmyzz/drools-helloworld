package com.cnblogs.yjmyzz.drools.demo.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PendingItems {
    private Customer customer;
    private List<CartItem> cartItems = new ArrayList<CartItem>();

    public PendingItems(Customer customer) {
        this.customer = customer;
    }

    public void addItem(CartItem cartItem) {
        cartItems.add(cartItem);
    }
}
