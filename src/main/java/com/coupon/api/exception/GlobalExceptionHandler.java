package com.coupon.api.exception;

import com.coupon.domain.exception.CouponAlreadyDeletedException;
import com.coupon.domain.exception.InvalidCouponCodeException;
import com.coupon.domain.exception.InvalidDiscountValueException;
import com.coupon.domain.exception.InvalidExpirationDateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCouponCodeException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidCouponCode(InvalidCouponCodeException ex) {
        return build(HttpStatus.BAD_REQUEST, "INVALID_COUPON_CODE", ex.getMessage());
    }

    @ExceptionHandler(InvalidDiscountValueException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidDiscountValue(InvalidDiscountValueException ex) {
        return build(HttpStatus.BAD_REQUEST, "INVALID_DISCOUNT_VALUE", ex.getMessage());
    }

    @ExceptionHandler(InvalidExpirationDateException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidExpirationDate(InvalidExpirationDateException ex) {
        return build(HttpStatus.BAD_REQUEST, "INVALID_EXPIRATION_DATE", ex.getMessage());
    }

    @ExceptionHandler(CouponAlreadyDeletedException.class)
    public ResponseEntity<ApiErrorResponse> handleCouponAlreadyDeleted(CouponAlreadyDeletedException ex) {
        return build(HttpStatus.CONFLICT, "COUPON_ALREADY_DELETED", ex.getMessage());
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