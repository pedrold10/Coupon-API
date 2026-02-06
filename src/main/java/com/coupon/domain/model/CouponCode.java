package com.coupon.domain.model;

import com.coupon.domain.exception.InvalidCouponCodeException;

public class CouponCode {

    private final String value;

    public CouponCode(String rawCode) {
        if (rawCode == null) {
            throw new InvalidCouponCodeException();
        }

        String normalized = rawCode.replaceAll("[^a-zA-Z0-9]", "");

        if (normalized.length() != 6) {
            throw new InvalidCouponCodeException();
        }

        this.value = normalized.toUpperCase();
    }

    public String getValue() {
        return value;
    }
}

