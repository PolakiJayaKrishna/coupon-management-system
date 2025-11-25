package com.example.couponmanagement.model;

public class BestCouponResult {

    private Coupon bestCoupon;
    private double discountAmount;
    private double finalCartValue;

    public BestCouponResult() {}

    public BestCouponResult(Coupon bestCoupon, double discountAmount, double finalCartValue) {
        this.bestCoupon = bestCoupon;
        this.discountAmount = discountAmount;
        this.finalCartValue = finalCartValue;
    }

    public Coupon getBestCoupon() {
        return bestCoupon;
    }

    public void setBestCoupon(Coupon bestCoupon) {
        this.bestCoupon = bestCoupon;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getFinalCartValue() {
        return finalCartValue;
    }

    public void setFinalCartValue(double finalCartValue) {
        this.finalCartValue = finalCartValue;
    }
}
