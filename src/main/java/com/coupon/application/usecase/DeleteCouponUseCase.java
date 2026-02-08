package com.coupon.application.usecase;

import com.coupon.application.port.CouponRepository;
import com.coupon.domain.exception.CouponNotFoundException;
import com.coupon.domain.model.Coupon;

import java.util.UUID;

public class DeleteCouponUseCase {

    private final CouponRepository repository;

    public DeleteCouponUseCase(CouponRepository repository) {
        this.repository = repository;
    }

    public void execute(UUID id) {
        Coupon coupon = repository.findById(id)
                .orElseThrow(CouponNotFoundException::new);

        coupon.delete();

        repository.save(coupon);
    }
}
