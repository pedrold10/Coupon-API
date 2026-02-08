package com.coupon.api.controller;

import com.coupon.api.dto.CouponResponse;
import com.coupon.api.dto.CreateCouponRequest;
import com.coupon.application.dto.CouponOutput;
import com.coupon.application.dto.CreateCouponCommand;
import com.coupon.application.usecase.CreateCouponUseCase;
import com.coupon.application.usecase.DeleteCouponUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    private final CreateCouponUseCase createCouponUseCase;
    private final DeleteCouponUseCase deleteCouponUseCase;

    public CouponController(CreateCouponUseCase createCouponUseCase, DeleteCouponUseCase deleteCouponUseCase) {
        this.createCouponUseCase = createCouponUseCase;
        this.deleteCouponUseCase = deleteCouponUseCase;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteCouponUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

}
