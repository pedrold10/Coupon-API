package com.coupon.domain.exception;

public class InvalidExpirationDateException extends RuntimeException{
    public InvalidExpirationDateException(){
        super("Data de Expiração inválida!");
    }
}
