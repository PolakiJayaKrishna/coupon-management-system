package com.example.couponmanagement;

import com.example.couponmanagement.model.Coupon;
import com.example.couponmanagement.model.Eligibility;
import com.example.couponmanagement.service.CouponService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final CouponService couponService;

    public DataLoader(CouponService couponService) {
        this.couponService = couponService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Seed Data

        // 1. Flat discount for Cart > 1000
        Coupon c1 = new Coupon();
        c1.setCode("SAVE100");
        c1.setDescription("Save 100 on orders above 1000");
        c1.setDiscountType("FLAT");
        c1.setDiscountValue(100.0);
        c1.setStartDate(LocalDateTime.now().minusDays(1));
        c1.setEndDate(LocalDateTime.now().plusDays(30));
        
        Eligibility e1 = new Eligibility();
        e1.setMinCartValue(1000.0);
        c1.setEligibility(e1);
        
        couponService.createCoupon(c1);

        // 2. 10% off for Electronics
        Coupon c2 = new Coupon();
        c2.setCode("ELEC10");
        c2.setDescription("10% off on Electronics");
        c2.setDiscountType("PERCENT");
        c2.setDiscountValue(10.0);
        c2.setMaxDiscountAmount(500.0);
        c2.setStartDate(LocalDateTime.now().minusDays(1));
        c2.setEndDate(LocalDateTime.now().plusDays(30));
        
        Eligibility e2 = new Eligibility();
        e2.setApplicableCategories(List.of("electronics"));
        c2.setEligibility(e2);
        
        couponService.createCoupon(c2);

        // 3. New User Coupon
        Coupon c3 = new Coupon();
        c3.setCode("WELCOME50");
        c3.setDescription("50% off for new users");
        c3.setDiscountType("PERCENT");
        c3.setDiscountValue(50.0);
        c3.setMaxDiscountAmount(200.0);
        c3.setStartDate(LocalDateTime.now().minusDays(1));
        c3.setEndDate(LocalDateTime.now().plusDays(30));
        
        Eligibility e3 = new Eligibility();
        e3.setAllowedUserTiers(List.of("NEW"));
        c3.setEligibility(e3);
        
        couponService.createCoupon(c3);
        
        System.out.println("Seed data loaded: 3 coupons created.");
        
        // Seed Demo User
        System.out.println("Demo login credentials: email=hire-me@anshumat.org | password=HireMe@2025!");
        com.example.couponmanagement.config.DemoUserStore.put("hire-me@anshumat.org", "HireMe@2025!");
    }
}
