package com.coupon.api.exception;

import com.coupon.domain.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCouponCodeException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidCouponCode(InvalidCouponCodeException e) {
        return build(HttpStatus.BAD_REQUEST, "INVALID_COUPON_CODE", e.getMessage());
    }

    @ExceptionHandler(InvalidDiscountValueException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidDiscountValue(InvalidDiscountValueException e) {
        return build(HttpStatus.BAD_REQUEST, "INVALID_DISCOUNT_VALUE", e.getMessage());
    }

    @ExceptionHandler(InvalidExpirationDateException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidExpirationDate(InvalidExpirationDateException e) {
        return build(HttpStatus.BAD_REQUEST, "INVALID_EXPIRATION_DATE", e.getMessage());
    }

    @ExceptionHandler(CouponNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFound(CouponNotFoundException e) {
        return build(HttpStatus.NOT_FOUND, "COUPON_NOT_FOUND", e.getMessage());
    }
    @ExceptionHandler(CouponAlreadyDeletedException.class)
    public ResponseEntity<ApiErrorResponse> handleCouponAlreadyDeleted(CouponAlreadyDeletedException e) {
        return build(HttpStatus.CONFLICT, "COUPON_ALREADY_DELETED", e.getMessage());
    }

    private ResponseEntity<ApiErrorResponse> build(
            HttpStatus status,
            String error,
            String message
    ) {
        return ResponseEntity
                .status(status)
                .body(new ApiErrorResponse(status.value(), error, message));
    }
}