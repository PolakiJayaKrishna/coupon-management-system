package com.example.couponmanagement.model;
import java.util.List;

public class Eligibility {
    private Integer minAge;
    private Integer maxAge;

    private List<String> requiredLocations;
    private List<String> excludedLocations;


    private Integer minTotalOrders;
    private Integer maxTotalOrders;

    private java.util.List<String> requiredPastCategories;
    private java.util.List<String> excludedPastCategories;

    private Double minCartValue;
    private Double maxCartValue;

    public Eligibility() {}

    public Eligibility(Integer minAge, Integer maxAge,
                       java.util.List<String> requiredLocations,
                       java.util.List<String> excludedLocations,
                       Integer minTotalOrders, Integer maxTotalOrders,
                       java.util.List<String> requiredPastCategories,
                       java.util.List<String> excludedPastCategories,
                       Double minCartValue, Double maxCartValue) {

        this.minAge = minAge;
        this.maxAge = maxAge;
        this.requiredLocations = requiredLocations;
        this.excludedLocations = excludedLocations;
        this.minTotalOrders = minTotalOrders;
        this.maxTotalOrders = maxTotalOrders;
        this.requiredPastCategories = requiredPastCategories;
        this.excludedPastCategories = excludedPastCategories;
        this.minCartValue = minCartValue;
        this.maxCartValue = maxCartValue;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public List<String> getRequiredLocations() {
        return requiredLocations;
    }

    public void setRequiredLocations(List<String> requiredLocations) {
        this.requiredLocations = requiredLocations;
    }

    public List<String> getExcludedLocations() {
        return excludedLocations;
    }

    public void setExcludedLocations(List<String> excludedLocations) {
        this.excludedLocations = excludedLocations;
    }

    public Integer getMinTotalOrders() {
        return minTotalOrders;
    }

    public void setMinTotalOrders(Integer minTotalOrders) {
        this.minTotalOrders = minTotalOrders;
    }

    public Integer getMaxTotalOrders() {
        return maxTotalOrders;
    }

    public void setMaxTotalOrders(Integer maxTotalOrders) {
        this.maxTotalOrders = maxTotalOrders;
    }

    public List<String> getRequiredPastCategories() {
        return requiredPastCategories;
    }

    public void setRequiredPastCategories(List<String> requiredPastCategories) {
        this.requiredPastCategories = requiredPastCategories;
    }

    public List<String> getExcludedPastCategories() {
        return excludedPastCategories;
    }

    public void setExcludedPastCategories(List<String> excludedPastCategories) {
        this.excludedPastCategories = excludedPastCategories;
    }

    public Double getMinCartValue() {
        return minCartValue;
    }

    public void setMinCartValue(Double minCartValue) {
        this.minCartValue = minCartValue;
    }

    public Double getMaxCartValue() {
        return maxCartValue;
    }

    public void setMaxCartValue(Double maxCartValue) {
        this.maxCartValue = maxCartValue;
    }
}
