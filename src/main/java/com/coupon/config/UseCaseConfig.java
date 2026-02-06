package com.coupon.config;

import com.coupon.application.port.CouponRepository;
import com.coupon.application.usecase.CreateCouponUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public CreateCouponUseCase createCouponUseCase(CouponRepository couponRepository) {
        return new CreateCouponUseCase(couponRepository);
    }
}
