package com.coupon.infraestructure.persistance.entity.repository;

import com.coupon.application.port.CouponRepository;
import com.coupon.domain.model.Coupon;
import com.coupon.domain.model.CouponCode;
import com.coupon.domain.model.DiscountValue;
import com.coupon.infraestructure.persistance.entity.CouponEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Primary
@Repository
public class CouponJpaAdapter implements CouponRepository {

    private final JpaCouponRepository jpaRepository;

    public CouponJpaAdapter(JpaCouponRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Coupon> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(entity -> Coupon.rehydrate(
                        entity.getId(),
                        new CouponCode(entity.getCode()),
                        entity.getDescription(),
                        new DiscountValue(entity.getDiscountValue()),
                        entity.getExpirationDate(),
                        entity.isPublished(),
                        entity.isRedeemed(),
                        entity.getStatus()
                ));
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

        return Coupon.rehydrate(
                saved.getId(),
                new CouponCode(saved.getCode()),
                saved.getDescription(),
                new DiscountValue(saved.getDiscountValue()),
                saved.getExpirationDate(),
                saved.isPublished(),
                saved.isRedeemed(),
                saved.getStatus()
        );
    }
}
