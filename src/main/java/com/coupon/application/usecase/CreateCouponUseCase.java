package com.coupon.application.usecase;

import com.coupon.application.dto.CouponOutput;
import com.coupon.application.dto.CreateCouponCommand;
import com.coupon.application.port.CouponRepository;
import com.coupon.domain.model.Coupon;
import com.coupon.domain.model.CouponCode;
import com.coupon.domain.model.DiscountValue;

public class CreateCouponUseCase {
    private final CouponRepository couponRepository;

    public CreateCouponUseCase(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public CouponOutput execute(CreateCouponCommand command) {

        Coupon coupon = Coupon.create(
                new CouponCode(command.getCode()),
                command.getDescription(),
                new DiscountValue(command.getDiscountValue()),
                command.getExpirationDate(),
                command.isPublished()
        );

        Coupon savedCoupon = couponRepository.save(coupon);

        return new CouponOutput(
                savedCoupon.getId(),
                savedCoupon.getCode().getValue(),
                savedCoupon.getDescription(),
                savedCoupon.getDiscountValue().getValue(),
                savedCoupon.getExpirationDate(),
                savedCoupon.getStatus(),
                savedCoupon.isPublished(),
                savedCoupon.isRedeemed()
        );
    }
}
