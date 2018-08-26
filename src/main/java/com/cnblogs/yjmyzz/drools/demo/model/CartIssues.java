package com.cnblogs.yjmyzz.drools.demo.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jimmy
 */
public class CartIssues {
    private Map<String, CartItem> cartErrors = new HashMap<String, CartItem>();

    public void logItemError(String key, CartItem cartItem) {
        cartErrors.put(key, cartItem);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String key : cartErrors.keySet()) {
            sb.append(cartErrors.get(key)).append("\n");
        }
        String result = sb.toString();
        if (result.length() > 0) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    public boolean hasIssues() {
        return !cartErrors.isEmpty();
    }
}
