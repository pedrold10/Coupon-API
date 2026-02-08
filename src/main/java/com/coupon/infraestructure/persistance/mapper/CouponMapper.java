package com.coupon.infraestructure.persistance.mapper;

import com.coupon.domain.model.Coupon;
import com.coupon.domain.model.CouponCode;
import com.coupon.domain.model.DiscountValue;
import com.coupon.infraestructure.persistance.entity.CouponEntity;

public class CouponMapper {
    public static CouponEntity toEntity(Coupon coupon) {
        return new CouponEntity(
                coupon.getId(),
                coupon.getCode().getValue(),
                coupon.getDescription(),
                coupon.getDiscountValue().getValue(),
                coupon.isRedeemed(),
                coupon.isPublished(),
                coupon.getStatus(),
                coupon.getExpirationDate()
        );
    }
    public static Coupon toDomain(CouponEntity e) {
        return Coupon.rehydrate(
                e.getId(),
                new CouponCode(e.getCode()),
                e.getDescription(),
                new DiscountValue(e.getDiscountValue()),
                e.getExpirationDate(),
                e.isPublished(),
                e.isRedeemed(),
                e.getStatus()
        );
    }
}
