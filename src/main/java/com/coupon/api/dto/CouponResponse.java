package com.coupon.api.dto;

import com.coupon.domain.model.CouponStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class CouponResponse {
    private UUID id;
    private String code;
    private String description;
    private BigDecimal discountValue;
    private Instant expirationDate;
    private CouponStatus status;
    private boolean published;
    private boolean redeemed;

    public CouponResponse(UUID id, String code, String description, BigDecimal discountValue, Instant expirationDate, CouponStatus status, boolean published, boolean redeemed) {
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

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public Instant getExpirationDate() {
        return expirationDate;
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
