package com.example.couponmanagement.model;

import java.time.LocalDate;

public class Coupon {
    private String code;
    private String description;
    private String discountType;  // FLAT or PERCENT
    private double discountValue;
    private Double maxDiscountAmount; // optional
    private java.time.LocalDate startDate;
    private java.time.LocalDate endDate;
    private Integer usageLimitPerUser; // optional
    private Eligibility eligibility;  // nested rules

    public Coupon() {}

    public Coupon(String code, String description, String discountType, double discountValue,
                  Double maxDiscountAmount, java.time.LocalDate startDate, java.time.LocalDate endDate,
                  Integer usageLimitPerUser, Eligibility eligibility) {

        this.code = code;
        this.description = description;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.maxDiscountAmount = maxDiscountAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.usageLimitPerUser = usageLimitPerUser;
        this.eligibility = eligibility;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }

    public Double getMaxDiscountAmount() {
        return maxDiscountAmount;
    }

    public void setMaxDiscountAmount(Double maxDiscountAmount) {
        this.maxDiscountAmount = maxDiscountAmount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getUsageLimitPerUser() {
        return usageLimitPerUser;
    }

    public void setUsageLimitPerUser(Integer usageLimitPerUser) {
        this.usageLimitPerUser = usageLimitPerUser;
    }

    public Eligibility getEligibility() {
        return eligibility;
    }

    public void setEligibility(Eligibility eligibility) {
        this.eligibility = eligibility;
    }
}
