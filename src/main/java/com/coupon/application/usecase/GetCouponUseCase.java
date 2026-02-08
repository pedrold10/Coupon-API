package com.coupon.application.usecase;

import com.coupon.application.dto.CouponOutput;
import com.coupon.application.port.CouponRepository;
import com.coupon.domain.exception.CouponNotFoundException;
import com.coupon.domain.model.Coupon;

import java.util.UUID;

public class GetCouponUseCase {

    private final CouponRepository repository;

    public GetCouponUseCase(CouponRepository repository) {
        this.repository = repository;
    }

    public CouponOutput execute(UUID id) {
        Coupon coupon = repository.findById(id)
                .orElseThrow(() -> new CouponNotFoundException(id));

        return CouponOutput.from(coupon);
    }
}
