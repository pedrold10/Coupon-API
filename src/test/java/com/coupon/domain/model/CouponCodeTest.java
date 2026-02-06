package com.coupon.domain.model;

import com.coupon.domain.exception.InvalidCouponCodeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CouponCodeTest {

    @Test
    void shouldNormalizeAndUppercaseCode() {
        CouponCode code = new CouponCode("abc-123");

        assertEquals("ABC123", code.getValue());
    }

    @Test
    void shouldThrowExceptionWhenCodeIsNull() {
        assertThrows(
                InvalidCouponCodeException.class,
                () -> new CouponCode(null)
        );
    }

    @Test
    void shouldThrowExceptionWhenCodeLengthIsInvalid() {
        assertThrows(
                InvalidCouponCodeException.class,
                () -> new CouponCode("A1")
        );
    }

}
