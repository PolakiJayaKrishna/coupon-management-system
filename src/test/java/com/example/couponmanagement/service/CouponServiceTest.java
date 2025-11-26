package com.example.couponmanagement.service;

import com.example.couponmanagement.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CouponServiceTest {

    private CouponService couponService;

    @BeforeEach
    void setUp() {
        couponService = new CouponService();
    }

    @Test
    void testCreateAndGetCoupons() {
        Coupon c = new Coupon();
        c.setCode("TEST1");
        couponService.createCoupon(c);
        
        assertEquals(1, couponService.getAllCoupons().size());
        assertEquals("TEST1", couponService.getAllCoupons().get(0).getCode());
    }

    @Test
    void testBestCouponSelection_HighestDiscount() {
        // Coupon 1: Flat 100
        Coupon c1 = new Coupon();
        c1.setCode("FLAT100");
        c1.setDiscountType("FLAT");
        c1.setDiscountValue(100.0);
        c1.setStartDate(LocalDateTime.now().minusDays(1));
        c1.setEndDate(LocalDateTime.now().plusDays(1));
        couponService.createCoupon(c1);

        // Coupon 2: Flat 200
        Coupon c2 = new Coupon();
        c2.setCode("FLAT200");
        c2.setDiscountType("FLAT");
        c2.setDiscountValue(200.0);
        c2.setStartDate(LocalDateTime.now().minusDays(1));
        c2.setEndDate(LocalDateTime.now().plusDays(1));
        couponService.createCoupon(c2);

        UserContext user = new UserContext("u1", "REGULAR", "US", 1000.0, 5);
        Cart cart = new Cart(List.of(new Item("p1", "cat1", 500.0, 1))); // Total 500

        Coupon best = couponService.findBestCoupon(user, cart);
        assertNotNull(best);
        assertEquals("FLAT200", best.getCode());
    }

    @Test
    void testBestCouponSelection_TieBreaker_EndDate() {
        // Coupon 1: Flat 100, expires in 2 days
        Coupon c1 = new Coupon();
        c1.setCode("LATER");
        c1.setDiscountType("FLAT");
        c1.setDiscountValue(100.0);
        c1.setStartDate(LocalDateTime.now().minusDays(1));
        c1.setEndDate(LocalDateTime.now().plusDays(2));
        couponService.createCoupon(c1);

        // Coupon 2: Flat 100, expires in 1 day (should win)
        Coupon c2 = new Coupon();
        c2.setCode("SOONER");
        c2.setDiscountType("FLAT");
        c2.setDiscountValue(100.0);
        c2.setStartDate(LocalDateTime.now().minusDays(1));
        c2.setEndDate(LocalDateTime.now().plusDays(1));
        couponService.createCoupon(c2);

        UserContext user = new UserContext("u1", "REGULAR", "US", 1000.0, 5);
        Cart cart = new Cart(List.of(new Item("p1", "cat1", 500.0, 1)));

        Coupon best = couponService.findBestCoupon(user, cart);
        assertNotNull(best);
        assertEquals("SOONER", best.getCode());
    }

    @Test
    void testEligibility_MinCartValue() {
        Coupon c = new Coupon();
        c.setCode("MINCART");
        c.setDiscountType("FLAT");
        c.setDiscountValue(50.0);
        c.setStartDate(LocalDateTime.now().minusDays(1));
        c.setEndDate(LocalDateTime.now().plusDays(1));
        
        Eligibility e = new Eligibility();
        e.setMinCartValue(100.0);
        c.setEligibility(e);
        couponService.createCoupon(c);

        UserContext user = new UserContext("u1", "REGULAR", "US", 1000.0, 5);
        
        // Cart value 50 - should fail
        Cart cart1 = new Cart(List.of(new Item("p1", "cat1", 50.0, 1)));
        assertNull(couponService.findBestCoupon(user, cart1));

        // Cart value 150 - should pass
        Cart cart2 = new Cart(List.of(new Item("p1", "cat1", 150.0, 1)));
        assertNotNull(couponService.findBestCoupon(user, cart2));
    }
    
    @Test
    void testEligibility_UserTier() {
        Coupon c = new Coupon();
        c.setCode("GOLDONLY");
        c.setDiscountType("FLAT");
        c.setDiscountValue(50.0);
        c.setStartDate(LocalDateTime.now().minusDays(1));
        c.setEndDate(LocalDateTime.now().plusDays(1));
        
        Eligibility e = new Eligibility();
        e.setAllowedUserTiers(List.of("GOLD"));
        c.setEligibility(e);
        couponService.createCoupon(c);

        Cart cart = new Cart(List.of(new Item("p1", "cat1", 150.0, 1)));

        // Regular user - fail
        UserContext user1 = new UserContext("u1", "REGULAR", "US", 1000.0, 5);
        assertNull(couponService.findBestCoupon(user1, cart));

        // Gold user - pass
        UserContext user2 = new UserContext("u2", "GOLD", "US", 1000.0, 5);
        assertNotNull(couponService.findBestCoupon(user2, cart));
    }
}
