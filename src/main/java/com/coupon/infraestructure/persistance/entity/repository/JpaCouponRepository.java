package com.coupon.infraestructure.persistance.entity.repository;

import com.coupon.infraestructure.persistance.entity.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaCouponRepository extends JpaRepository<CouponEntity, UUID> {
}
