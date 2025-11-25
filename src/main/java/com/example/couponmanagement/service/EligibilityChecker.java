package com.example.couponmanagement.service;

import com.example.couponmanagement.model.*;

public class EligibilityChecker {

    public boolean isEligible(Coupon coupon, UserContext user, Cart cart) {
        Eligibility rules = coupon.getEligibility();

        if (rules == null) return true; // no rules = always eligible

        // Rule 1: Minimum age check
        if (rules.getMinAge() != null && user.getAge() < rules.getMinAge()) {
            return false;
        }

        // Rule 2: Maximum age check
        if (rules.getMaxAge() != null && user.getAge() > rules.getMaxAge()) {
            return false;
        }

        // Rule 3: Required locations check
        if (rules.getRequiredLocations() != null && !rules.getRequiredLocations().isEmpty()) {
            if (!rules.getRequiredLocations().contains(user.getLocation())) {
                return false;
            }
        }

        // Rule 4: Excluded locations check
        if (rules.getExcludedLocations() != null && !rules.getExcludedLocations().isEmpty()) {
            if (rules.getExcludedLocations().contains(user.getLocation())) {
                return false;
            }
        }

        // Rule 5: Minimum total orders check
        if (rules.getMinTotalOrders() != null && user.getTotalOrders() < rules.getMinTotalOrders()) {
            return false;
        }

        // Rule 6: Maximum total orders check
        if (rules.getMaxTotalOrders() != null && user.getTotalOrders() > rules.getMaxTotalOrders()) {
            return false;
        }

        // Rule 7: Required past categories check
        if (rules.getRequiredPastCategories() != null && !rules.getRequiredPastCategories().isEmpty()) {
            boolean hasRequiredCategory = false;

            for (String category : user.getPastCategories()) {
                if (rules.getRequiredPastCategories().contains(category)) {
                    hasRequiredCategory = true;
                    break;
                }
            }

            if (!hasRequiredCategory) {
                return false;
            }
        }

        // Rule 8: Excluded past categories check
        if (rules.getExcludedPastCategories() != null && !rules.getExcludedPastCategories().isEmpty()) {
            for (String category : user.getPastCategories()) {
                if (rules.getExcludedPastCategories().contains(category)) {
                    return false;
                }
            }
        }

        // Rule 9: Minimum cart value check
        if (rules.getMinCartValue() != null && cart.getCartValue() < rules.getMinCartValue()) {
            return false;
        }

        // Rule 10: Maximum cart value check
        if (rules.getMaxCartValue() != null && cart.getCartValue() > rules.getMaxCartValue()) {
            return false;
        }


        // checks will come here
        return true;
    }
}
