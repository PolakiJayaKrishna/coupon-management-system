package com.example.couponmanagement.controller;

import com.example.couponmanagement.model.Cart;
import com.example.couponmanagement.model.Coupon;
import com.example.couponmanagement.model.UserContext;
import com.example.couponmanagement.service.CouponService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping("/coupons")
    public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon) {
        Coupon created = couponService.createCoupon(coupon);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/coupons")
    public ResponseEntity<List<Coupon>> getAllCoupons() {
        return ResponseEntity.ok(couponService.getAllCoupons());
    }

    @PostMapping("/applicable-coupons")
    public ResponseEntity<Map<String, Object>> getBestCoupon(@RequestBody Map<String, Object> request) {
        // Manually deserializing to avoid creating a dedicated wrapper class for the request body
        // Request body: { "user": {...}, "cart": {...} }
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        UserContext user = mapper.convertValue(request.get("user"), UserContext.class);
        Cart cart = mapper.convertValue(request.get("cart"), Cart.class);

        Coupon bestCoupon = couponService.findBestCoupon(user, cart);

        if (bestCoupon == null) {
            return ResponseEntity.ok(Map.of("message", "No applicable coupon found"));
        }

        double discount = couponService.calculateDiscount(bestCoupon, cart);
        
        return ResponseEntity.ok(Map.of(
                "coupon", bestCoupon,
                "discount", discount
        ));
    }
}
