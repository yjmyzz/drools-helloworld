package com.cnblogs.yjmyzz.drools.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Customer {
    private String id;
    private Cart cart;
    private String coupon;
    private boolean isNew;
    private List<Product> registeredProducts = new ArrayList<Product>();

    public static Customer newCustomer(String id) {
        Customer customer = new Customer(id);
        customer.isNew = true;
        return customer;
    }

    private Customer(String id) {
        this.id = id;
    }

    public void addItem(Product product, int qty) {
        if (cart == null) {
            cart = new Cart(this);
        }
        cart.addItem(product, qty);
    }

    public void registerProduct(Product product) {
        registeredProducts.add(product);
    }

    public boolean isRegistered(Product p) {
        return registeredProducts.contains(p);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id)
                .append(",是否新用户：" + isNew)
                .append(",优惠券: ")
                .append(coupon == null ? "无" : coupon)
                .append("\n")
                .append(cart);
        return sb.toString();
    }
}
