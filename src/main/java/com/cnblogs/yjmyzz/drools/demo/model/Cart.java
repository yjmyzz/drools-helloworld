package com.cnblogs.yjmyzz.drools.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jimmy
 */
@Setter
@Getter
public class Cart {
    private Customer customer;
    private List<CartItem> cartItems = new ArrayList<CartItem>();
    private double discount;
    private CartIssues cartIssues = new CartIssues();
    private PendingItems pendingItems = new PendingItems(customer);

    public Cart(Customer customer) {
        this.customer = customer;
    }

    public void addItem(Product p, int qty) {
        CartItem cartItem = new CartItem(this, p, qty);
        cartItems.add(cartItem);
    }

    public void addDiscount(double discount) {
        this.discount += discount;
    }

    public int getTotalPrice() {
        int total = 0;
        for (CartItem item : cartItems) {
            if (item.isErrors()) {
                continue;
            }
            total += item.getProduct().getPrice() * item.getQty();
        }
        return total;
    }

    public int getFinalPrice() {
        return getTotalPrice() - (int) getDiscount();
    }

    public void logItemError(String key, CartItem cartItem) {
        cartIssues.logItemError(key, cartItem);
        pendingItems.addItem(cartItem);
        cartItem.setCartStatus(CartStatus.PENDING);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("购物车详情:\n");
        for (CartItem cartItem : cartItems) {
            sb.append("\t" + cartItem).append("\n");
        }
        sb.append("折扣金额: ")
                .append(getDiscount())
                .append("\n折前总额: ")
                .append(getTotalPrice())
                .append("\n折后总额: ")
                .append(getFinalPrice());
        return sb.toString();
    }


    public boolean hasIssues() {
        return cartIssues.hasIssues();
    }
}
