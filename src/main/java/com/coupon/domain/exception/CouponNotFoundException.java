package com.coupon.domain.exception;

public class CouponNotFoundException extends RuntimeException{
    public CouponNotFoundException() {
        super("Cupom não encontrado!");
    }
}
