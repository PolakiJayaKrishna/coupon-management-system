package com.example.couponmanagement.controller;

import com.example.couponmanagement.model.*;
import com.example.couponmanagement.service.CouponService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    // API 1: Create Coupon
    @PostMapping("/coupons")
    public Coupon createCoupon(@RequestBody Coupon coupon) {
        return couponService.saveCoupon(coupon);
    }

    // API 2: Best Coupon
    @PostMapping("/best-coupon")
    public BestCouponResult getBestCoupon(@RequestBody BestCouponRequest req) {
        return couponService.getBestCoupon(req.getUser(), req.getCart());
    }

    // API 3: Get All Coupons
    @GetMapping("/coupons")
    public List<Coupon> getAllCoupons() {
        return couponService.getAllCoupons();
    }
}
