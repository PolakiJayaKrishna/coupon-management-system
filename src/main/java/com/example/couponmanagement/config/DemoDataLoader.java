package com.example.couponmanagement.config;

import com.example.couponmanagement.model.*;
import com.example.couponmanagement.service.CouponService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Seeds sample coupons and a demo user at application startup.
 */
@Component
public class DemoDataLoader {

    private final CouponService couponService;

    public DemoDataLoader(CouponService couponService) {
        this.couponService = couponService;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void seed() {
        System.out.println("Seeding demo coupons...");

        // 1) FLAT coupon
        Coupon flat = new Coupon(
                "FLAT100",
                "Flat ₹100 off on any order",
                "FLAT",
                100.0,
                null,
                LocalDate.now().minusDays(1),
                LocalDate.now().plusMonths(6),
                null,
                null
        );
        couponService.saveCoupon(flat);

        // 2) PERCENT coupon with cap
        Coupon percentCap = new Coupon(
                "TENPERCAP",
                "10% off up to ₹200",
                "PERCENT",
                10.0,
                200.0,
                LocalDate.now().minusDays(1),
                LocalDate.now().plusMonths(6),
                null,
                null
        );
        couponService.saveCoupon(percentCap);

        // 3) Location-restricted coupon (only IN)
        Eligibility locEligibility = new Eligibility();
        locEligibility.setRequiredLocations(Arrays.asList("IN"));
        Coupon locationOnly = new Coupon(
                "INDIAONLY",
                "Special for India users",
                "FLAT",
                150.0,
                null,
                LocalDate.now().minusDays(1),
                LocalDate.now().plusMonths(6),
                null,
                locEligibility
        );
        couponService.saveCoupon(locationOnly);

        // 4) New-user coupon (maxTotalOrders = 0 or maxTotalOrders <= 1)
        Eligibility newUserEligibility = new Eligibility();
        newUserEligibility.setMaxTotalOrders(0); // only zero-order users
        Coupon newUser = new Coupon(
                "WELCOME1",
                "Welcome offer for first time users",
                "PERCENT",
                20.0,
                300.0,
                LocalDate.now().minusDays(1),
                LocalDate.now().plusMonths(6),
                1,
                newUserEligibility
        );
        couponService.saveCoupon(newUser);

        // 5) Category-based coupon
        Eligibility catEligibility = new Eligibility();
        catEligibility.setRequiredPastCategories(Arrays.asList("electronics", "appliances"));
        Coupon catCoupon = new Coupon(
                "ELECTRO5",
                "5% off for electronics buyers",
                "PERCENT",
                5.0,
                null,
                LocalDate.now().minusDays(1),
                LocalDate.now().plusMonths(3),
                null,
                catEligibility
        );
        couponService.saveCoupon(catCoupon);

        System.out.println("Seeded 5 demo coupons.");
        System.out.println("Demo login credentials: email=hire-me@anshumat.org | password=HireMe@2025!");
        DemoUserStore.put("hire-me@anshumat.org", "HireMe@2025!");
    }
}
