package com.coupon.config;

import com.coupon.application.port.CouponRepository;
import com.coupon.application.usecase.CreateCouponUseCase;
import com.coupon.application.usecase.DeleteCouponUseCase;
import com.coupon.application.usecase.GetCouponUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public CreateCouponUseCase createCouponUseCase(CouponRepository couponRepository) {
        return new CreateCouponUseCase(couponRepository);
    }
    @Bean
    public DeleteCouponUseCase deleteCouponUseCase(CouponRepository couponRepository) {
        return new DeleteCouponUseCase(couponRepository);
    }

    @Bean
    public GetCouponUseCase getCouponUseCase(CouponRepository repo) {
        return new GetCouponUseCase(repo);
    }

}
