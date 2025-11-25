package com.example.couponmanagement.repository;

import com.example.couponmanagement.model.Coupon;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryCouponRepository {

    private final List<Coupon> coupons = new ArrayList<>();

    public InMemoryCouponRepository() {
    }

    /**
     * Save coupon. If a coupon with the same code exists, overwrite it.
     * (Documented behavior: overwrite duplicates)
     */
    public synchronized Coupon save(Coupon coupon) {
        if (coupon == null || coupon.getCode() == null) {
            throw new IllegalArgumentException("coupon and coupon.code must not be null");
        }
        // remove existing with the same code
        coupons.removeIf(c -> coupon.getCode().equalsIgnoreCase(c.getCode()));
        coupons.add(coupon);
        return coupon;
    }

    /** Return the immutable list view of all coupons. */
    public List<Coupon> findAll() {
        return Collections.unmodifiableList(new ArrayList<>(coupons));
    }

    /** Find a coupon by code (case-insensitive). */
    public Optional<Coupon> findByCode(String code) {
        if (code == null) return Optional.empty();
        return coupons.stream()
                .filter(c -> code.equalsIgnoreCase(c.getCode()))
                .findFirst();
    }

    /** Clear all coupons (useful for tests). */
    public synchronized void clear() {
        coupons.clear();
    }
}
