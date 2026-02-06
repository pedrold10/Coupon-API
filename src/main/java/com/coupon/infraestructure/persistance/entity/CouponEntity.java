package com.coupon.infraestructure.persistance.entity;


import com.coupon.domain.model.CouponStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "coupons")
public class CouponEntity {

    @Id
    private UUID id;

    private String code;

    private String description;

    private BigDecimal discountValue;

    private Instant expirationDate;

    @Enumerated(EnumType.STRING)
    private CouponStatus status;

    private boolean published;

    private boolean redeemed;

    protected CouponEntity() {}

    public CouponEntity(UUID id, String code, String description, BigDecimal discountValue, boolean redeemed, boolean published, CouponStatus status, Instant expirationDate) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.discountValue = discountValue;
        this.expirationDate = expirationDate;
        this.published = published;
        this.redeemed = redeemed;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

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
