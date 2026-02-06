package com.coupon.domain.exception;

public class CouponAlreadyDeletedException extends RuntimeException {
    public CouponAlreadyDeletedException() {
        super("Cupom não pode ser deletado novamente!");
    }
}
