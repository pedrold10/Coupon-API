package com.coupon.application.port;

import com.coupon.domain.model.Coupon;

import java.util.Optional;
import java.util.UUID;

public interface CouponRepository {

    Optional<Coupon> findById(UUID id);

    Coupon save(Coupon coupon);

}
