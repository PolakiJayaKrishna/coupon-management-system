package com.example.couponmanagement.model;

public class BestCouponRequest {

    private UserContext user;
    private Cart cart;

    public BestCouponRequest() {}

    public BestCouponRequest(UserContext user, Cart cart) {
        this.user = user;
        this.cart = cart;
    }

    public UserContext getUser() {
        return user;
    }

    public void setUser(UserContext user) {
        this.user = user;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
