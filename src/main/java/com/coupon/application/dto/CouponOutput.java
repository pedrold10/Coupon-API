package com.coupon.application.dto;

import com.coupon.domain.model.CouponStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class CouponOutput {

    private final UUID id;
    private final String code;
    private final String description;
    private final BigDecimal discountValue;
    private final Instant expirationDate;
    private final CouponStatus status;
    private final boolean published;
    private final boolean redeemed;

    public CouponOutput(UUID id, String code, String description, BigDecimal discountValue, Instant expirationDate, CouponStatus status, boolean published, boolean redeemed) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.discountValue = discountValue;
        this.expirationDate = expirationDate;
        this.status = status;
        this.published = published;
        this.redeemed = redeemed;
    }

    public UUID getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Instant getExpirationDate() {
        return expirationDate;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public CouponStatus getStatus() {
        return status;
    }

    public boolean isPublished() {
        return published;
    }

    public boolean isRedeemed() {
        return redeemed;
    }
}
