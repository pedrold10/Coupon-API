package com.coupon.domain.model;

import com.coupon.domain.exception.CouponAlreadyDeletedException;
import com.coupon.domain.exception.InvalidExpirationDateException;

import java.time.Instant;
import java.util.UUID;

public class Coupon {
    private final UUID id;
    private final CouponCode code;
    private final String description;
    private final DiscountValue discountValue;
    private final Instant expirationDate;

    private CouponStatus status;
    private final boolean published;
    private final boolean redeemed;

    private Coupon(UUID id, CouponCode code, String description, DiscountValue discountValue, Instant expirationDate, boolean published){
        this.id = id;
        this.code = code;
        this.description = description;
        this.discountValue = discountValue;
        this.expirationDate = expirationDate;
        this.published = published;
        this.redeemed = false;
        this.status = published ? CouponStatus.ACTIVE : CouponStatus.INACTIVE;

    }

    public static Coupon create(
            CouponCode code,
            String description,
            DiscountValue discountValue,
            Instant expirationDate,
            boolean published
    ) {
        if (expirationDate.isBefore(Instant.now())) {
            throw new InvalidExpirationDateException();
        }

        return new Coupon(
                UUID.randomUUID(),
                code,
                description,
                discountValue,
                expirationDate,
                published
        );
    }

    public void delete() {
        if (this.status == CouponStatus.DELETED) {
            throw new CouponAlreadyDeletedException();
        }
        this.status = CouponStatus.DELETED;
    }

    public UUID getId() {
        return id;
    }

    public CouponCode getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public DiscountValue getDiscountValue() {
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
