package com.example.couponmanagement.model;

import java.util.List;

public class Cart {
    private List<Item> items;
    // totalValue can be computed or passed, but usually computed from items
    // We will compute it on the fly or allow it to be set if passed explicitly for some reason

    public Cart() {}

    public Cart(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalValue() {
        if (items == null) return 0.0;
        return items.stream().mapToDouble(i -> i.getUnitPrice() * i.getQuantity()).sum();
    }
}
