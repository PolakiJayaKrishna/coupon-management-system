package com.example.couponmanagement.service;

import com.example.couponmanagement.model.*;
import com.example.couponmanagement.repository.InMemoryCouponRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class CouponService {

    private final InMemoryCouponRepository repo;
    private final BestCouponService bestCouponService;

    @Autowired
    public CouponService(InMemoryCouponRepository repo, BestCouponService bestCouponService) {
        this.repo = repo;
        this.bestCouponService = bestCouponService;
    }

    public Coupon saveCoupon(Coupon coupon) {
        return repo.save(coupon);
    }

    public List<Coupon> getAllCoupons() {
        return repo.findAll();
    }

    public BestCouponResult getBestCoupon(UserContext user, Cart cart) {
        List<Coupon> all = repo.findAll();
        return bestCouponService.findBestCoupon(all, user, cart);
    }
}
