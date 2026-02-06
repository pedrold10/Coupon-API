package com.coupon.application.port;

import com.coupon.domain.model.Coupon;

public interface CouponRepository {

    Coupon save(Coupon coupon);

}
