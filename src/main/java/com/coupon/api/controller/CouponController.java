package com.coupon.api.controller;

import com.coupon.api.dto.CouponResponse;
import com.coupon.api.dto.CreateCouponRequest;
import com.coupon.application.dto.CouponOutput;
import com.coupon.application.dto.CreateCouponCommand;
import com.coupon.application.usecase.CreateCouponUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    private final CreateCouponUseCase createCouponUseCase;

    public CouponController(CreateCouponUseCase createCouponUseCase) {
        this.createCouponUseCase = createCouponUseCase;
    }

    @PostMapping
    public ResponseEntity<CouponResponse> create(@RequestBody CreateCouponRequest request) {

        CreateCouponCommand command = new CreateCouponCommand(
                request.getCode(),
                request.getDescription(),
                request.getDiscountValue(),
                request.getExpirationDate(),
                request.isPublished()
        );

        CouponOutput output = createCouponUseCase.execute(command);

        CouponResponse response = new CouponResponse(
                output.getId(),
                output.getCode(),
                output.getDescription(),
                output.getDiscountValue(),
                output.getExpirationDate(),
                output.getStatus(),
                output.isPublished(),
                output.isRedeemed()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
