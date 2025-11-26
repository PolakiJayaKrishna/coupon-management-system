package com.example.couponmanagement.model;

public class UserContext {
    private String userId;
    private String userTier; // "NEW", "REGULAR", "GOLD"
    private String country;
    private double lifetimeSpend;
    private int ordersPlaced;

    public UserContext() {}

    public UserContext(String userId, String userTier, String country, double lifetimeSpend, int ordersPlaced) {
        this.userId = userId;
        this.userTier = userTier;
        this.country = country;
        this.lifetimeSpend = lifetimeSpend;
        this.ordersPlaced = ordersPlaced;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserTier() {
        return userTier;
    }

    public void setUserTier(String userTier) {
        this.userTier = userTier;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLifetimeSpend() {
        return lifetimeSpend;
    }

    public void setLifetimeSpend(double lifetimeSpend) {
        this.lifetimeSpend = lifetimeSpend;
    }

    public int getOrdersPlaced() {
        return ordersPlaced;
    }

    public void setOrdersPlaced(int ordersPlaced) {
        this.ordersPlaced = ordersPlaced;
    }
}
