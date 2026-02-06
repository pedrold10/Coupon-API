package com.coupon.application.dto;

import java.math.BigDecimal;
import java.time.Instant;

public class CreateCouponCommand {

    private final String code;
    private final String description;
    private final BigDecimal discountValue;
    private final Instant expirationDate;
    private final boolean published;

    public CreateCouponCommand(String code, String description, BigDecimal discountValue, Instant expirationDate, boolean published) {
        this.code = code;
        this.description = description;
        this.discountValue = discountValue;
        this.expirationDate = expirationDate;
        this.published = published;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public Instant getExpirationDate() {
        return expirationDate;
    }

    public boolean isPublished() {
        return published;
    }
}
