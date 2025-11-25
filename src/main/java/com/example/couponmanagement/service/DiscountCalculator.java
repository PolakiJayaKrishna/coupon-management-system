package com.example.couponmanagement.service;

import com.example.couponmanagement.model.Cart;
import com.example.couponmanagement.model.Coupon;

public class DiscountCalculator {

    public double calculateDiscount(Coupon coupon, Cart cart) {
        if (coupon == null || cart == null) return 0.0;

        double cartValue = cart.getCartValue();
        if (cartValue <= 0) return 0.0;

        String type = coupon.getDiscountType();
        double value = coupon.getDiscountValue();

        double discount = 0.0;

        if (type == null) return 0.0;

        if ("FLAT".equalsIgnoreCase(type)) {
            discount = value;
        } else if ("PERCENT".equalsIgnoreCase(type)) {
            discount = cartValue * (value / 100.0);
            Double cap = coupon.getMaxDiscountAmount();
            if (cap != null) discount = Math.min(discount, cap);
        }

        if (discount < 0) discount = 0.0;
        if (discount > cartValue) discount = cartValue;

        return Math.round(discount * 100.0) / 100.0;
    }
}
