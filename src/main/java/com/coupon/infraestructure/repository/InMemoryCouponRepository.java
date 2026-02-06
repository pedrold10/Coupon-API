package com.coupon.infraestructure.repository;

import com.coupon.application.port.CouponRepository;
import com.coupon.domain.model.Coupon;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class InMemoryCouponRepository implements CouponRepository {

    private final Map<UUID, Coupon> storage = new HashMap<>();

    @Override
    public Coupon save(Coupon coupon) {
        storage.put(coupon.getId(), coupon);
        return coupon;
    }
}
