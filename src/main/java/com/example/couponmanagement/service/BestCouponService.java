package com.example.couponmanagement.service;

import com.example.couponmanagement.model.*;
import java.util.List;

public class BestCouponService {

    private final EligibilityChecker eligibilityChecker = new EligibilityChecker();
    private final DiscountCalculator discountCalculator = new DiscountCalculator();

    public BestCouponResult findBestCoupon(List<Coupon> coupons, UserContext user, Cart cart) {

        if (coupons == null || coupons.isEmpty()) {
            return new BestCouponResult(null, 0.0, cart.getCartValue());
        }

        Coupon best = null;
        double bestDiscount = 0.0;

        for (Coupon coupon : coupons) {

            // Step 1: Check eligibility
            if (!eligibilityChecker.isEligible(coupon, user, cart)) {
                continue;
            }

            // Step 2: Calculate discount
            double discount = discountCalculator.calculateDiscount(coupon, cart);

            // Step 3: Keep the best (highest discount)
            if (discount > bestDiscount) {
                bestDiscount = discount;
                best = coupon;
            }
        }

        double finalValue = cart.getCartValue() - bestDiscount;

        return new BestCouponResult(best, bestDiscount, finalValue);
    }


}
