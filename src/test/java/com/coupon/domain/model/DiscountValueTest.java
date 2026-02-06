package com.coupon.domain.model;

import com.coupon.domain.exception.InvalidDiscountValueException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiscountValueTest {

    @Test
    void shouldCreateDiscountValueWhenValid() {
        DiscountValue discount = new DiscountValue(BigDecimal.valueOf(0.8));

        assertEquals(BigDecimal.valueOf(0.8), discount.getValue());
    }

    @Test
    void shouldThrowExceptionWhenValueIsNull() {
        assertThrows(
                InvalidDiscountValueException.class,
                () -> new DiscountValue(null)
        );
    }

    @Test
    void shouldThrowExceptionWhenValueIsLessThanMinimum() {
        assertThrows(
                InvalidDiscountValueException.class,
                () -> new DiscountValue(BigDecimal.valueOf(0.4))
        );
    }

}
