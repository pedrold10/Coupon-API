package com.coupon.infraestructure.persistance.adapter;

import com.coupon.application.port.CouponRepository;
import com.coupon.domain.model.Coupon;
import com.coupon.infraestructure.persistance.entity.repository.JpaCouponRepository;
import com.coupon.infraestructure.persistance.mapper.CouponMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class CouponRepositoryImpl implements CouponRepository {

    private final JpaCouponRepository jpa;

    public CouponRepositoryImpl(JpaCouponRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Optional<Coupon> findById(UUID id) {
        return jpa.findById(id).map(CouponMapper::toDomain);
    }

    @Override
    public Coupon save(Coupon coupon) {
        return CouponMapper.toDomain(jpa.save(CouponMapper.toEntity(coupon)));
    }
}
