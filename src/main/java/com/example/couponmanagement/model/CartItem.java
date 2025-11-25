package com.example.couponmanagement.model;

public class CartItem {

    private String productId;
    private String category;
    private double unitPrice;
    private int quantity;

    public CartItem() {}

    public CartItem(String productId, String category, double unitPrice, int quantity) {
        this.productId = productId;
        this.category = category;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // Calculate the price of the item
    public double getTotal() {
        return unitPrice * quantity;
    }
}
