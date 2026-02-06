package com.coupon.domain.model;

import com.coupon.domain.exception.InvalidDiscountValueException;

import java.math.BigDecimal;

public class DiscountValue {

    private final BigDecimal value;

    public DiscountValue(BigDecimal value) {
        if (value == null || value.compareTo(BigDecimal.valueOf(0.5)) < 0) {
            throw new InvalidDiscountValueException();
        }
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}