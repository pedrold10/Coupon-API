package com.coupon.domain.exception;

public class InvalidCouponCodeException extends RuntimeException{
    public InvalidCouponCodeException(){
        super("Código de cupom inválido!");
    }

}
