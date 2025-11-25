package com.example.couponmanagement.service;

import com.example.couponmanagement.model.*;
import com.example.couponmanagement.repository.InMemoryCouponRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    private final InMemoryCouponRepository repo = new InMemoryCouponRepository();
    private final BestCouponService bestCouponService = new BestCouponService();

    // Save a coupon
    public Coupon saveCoupon(Coupon coupon) {
        return repo.save(coupon);
    }

    // Get all coupons
    public List<Coupon> getAllCoupons() {
        return repo.findAll();
    }

    // Find the best coupon
    public BestCouponResult getBestCoupon(UserContext user, Cart cart) {
        List<Coupon> all = repo.findAll();
        return bestCouponService.findBestCoupon(all, user, cart);
    }
}
