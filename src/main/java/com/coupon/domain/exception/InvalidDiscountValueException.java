package com.coupon.domain.exception;

public class InvalidDiscountValueException extends RuntimeException{
    public InvalidDiscountValueException(){
        super("Desconto no Valor Inválido");
    }
}
