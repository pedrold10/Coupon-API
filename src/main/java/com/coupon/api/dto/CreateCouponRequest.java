package com.coupon.api.dto;

import java.math.BigDecimal;
import java.time.Instant;

public class CreateCouponRequest {

    private String code;
    private String description;
    private BigDecimal discountValue;
    private Instant expirationDate;
    private boolean published;

    public String getCode() {
        return code;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public String getDescription() {
        return description;
    }

    public Instant getExpirationDate() {
        return expirationDate;
    }

    public boolean isPublished() {
        return published;
    }
}
