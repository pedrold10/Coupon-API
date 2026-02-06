package com.coupon.domain.model;

import com.coupon.domain.exception.CouponAlreadyDeletedException;
import com.coupon.domain.exception.InvalidExpirationDateException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CouponTest {

    @Test
    void shouldCreateActiveCouponWhenPublishedIsTrue() {
        Coupon coupon = Coupon.create(
                new CouponCode("ABC123"),
                "Descrição",
                new DiscountValue(BigDecimal.valueOf(0.8)),
                Instant.now().plusSeconds(3600),
                true
        );

        assertEquals(CouponStatus.ACTIVE, coupon.getStatus());
    }

    @Test
    void shouldCreateInactiveCouponWhenPublishedIsFalse() {
        Coupon coupon = Coupon.create(
                new CouponCode("ABC123"),
                "Descrição",
                new DiscountValue(BigDecimal.valueOf(0.8)),
                Instant.now().plusSeconds(3600),
                false
        );

        assertEquals(CouponStatus.INACTIVE, coupon.getStatus());
    }

    @Test
    void shouldThrowExceptionWhenExpirationDateIsInPast() {
        assertThrows(
                InvalidExpirationDateException.class,
                () -> Coupon.create(
                        new CouponCode("ABC123"),
                        "Descrição",
                        new DiscountValue(BigDecimal.valueOf(0.8)),
                        Instant.now().minusSeconds(10),
                        true
                )
        );
    }

    @Test
    void shouldDeleteCoupon() {
        Coupon coupon = Coupon.create(
                new CouponCode("ABC123"),
                "Descrição",
                new DiscountValue(BigDecimal.valueOf(0.8)),
                Instant.now().plusSeconds(3600),
                true
        );

        coupon.delete();

        assertEquals(CouponStatus.DELETED, coupon.getStatus());
    }

    @Test
    void shouldNotAllowDeleteTwice() {
        Coupon coupon = Coupon.create(
                new CouponCode("ABC123"),
                "Descrição",
                new DiscountValue(BigDecimal.valueOf(0.8)),
                Instant.now().plusSeconds(3600),
                true
        );

        coupon.delete();

        assertThrows(
                CouponAlreadyDeletedException.class,
                coupon::delete
        );
    }
}
