package com.example.couponmanagement.model;

import java.util.List;

public class Cart {

    private List<CartItem> items;

    public Cart() {}

    public Cart(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    // Calculate the total price of the entire cart
    public double getCartValue() {
        if (items == null) return 0;
        return items.stream().
                mapToDouble(CartItem::getTotal).
                sum();
    }

    // Total quantity of all items
    public int getTotalItemsCount() {
        if (items == null) return 0;
        return items.stream().
                mapToInt(CartItem::getQuantity).
                sum();
    }
}
