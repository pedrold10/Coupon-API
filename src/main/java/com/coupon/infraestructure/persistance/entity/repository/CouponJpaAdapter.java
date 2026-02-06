package com.coupon.infraestructure.persistance.entity.repository;

import com.coupon.application.port.CouponRepository;
import com.coupon.domain.model.Coupon;
import com.coupon.domain.model.CouponCode;
import com.coupon.domain.model.DiscountValue;
import com.coupon.infraestructure.persistance.entity.CouponEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CouponJpaAdapter implements CouponRepository {

    private final JpaCouponRepository jpaRepository;

    public CouponJpaAdapter(JpaCouponRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }


    @Override
    public Coupon save(Coupon coupon) {

        CouponEntity entity = new CouponEntity(
                coupon.getId(),
                coupon.getCode().getValue(),
                coupon.getDescription(),
                coupon.getDiscountValue().getValue(),
                coupon.isRedeemed(),
                coupon.isPublished(),
                coupon.getStatus(),
                coupon.getExpirationDate()
        );

        CouponEntity saved = jpaRepository.save(entity);

        return Coupon.create(
                new CouponCode(saved.getCode()),
                saved.getDescription(),
                new DiscountValue(saved.getDiscountValue()),
                saved.getExpirationDate(),
                saved.isPublished()
        );
    }
}
