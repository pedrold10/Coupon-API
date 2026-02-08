package com.coupon.api.controller;

import com.coupon.api.dto.CouponResponse;
import com.coupon.api.dto.CreateCouponRequest;
import com.coupon.application.dto.CouponOutput;
import com.coupon.application.dto.CreateCouponCommand;
import com.coupon.application.usecase.CreateCouponUseCase;
import com.coupon.application.usecase.DeleteCouponUseCase;
import com.coupon.application.usecase.GetCouponUseCase;
import com.coupon.domain.model.Coupon;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    private final CreateCouponUseCase createCouponUseCase;
    private final DeleteCouponUseCase deleteCouponUseCase;
    private final GetCouponUseCase getCouponUseCase;

    public CouponController(CreateCouponUseCase createCouponUseCase, DeleteCouponUseCase deleteCouponUseCase, GetCouponUseCase getCouponUseCase) {
        this.createCouponUseCase = createCouponUseCase;
        this.deleteCouponUseCase = deleteCouponUseCase;
        this.getCouponUseCase = getCouponUseCase;
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

    @GetMapping("/{id}")
    public ResponseEntity<CouponResponse> getById(@PathVariable UUID id) {
        CouponOutput output = getCouponUseCase.execute(id);

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

        return ResponseEntity.ok(response);
    }


}
