package com.coupon.application.usecase;

import com.coupon.application.dto.CouponOutput;
import com.coupon.application.port.CouponRepository;
import com.coupon.domain.model.Coupon;
import com.coupon.domain.model.CouponCode;
import com.coupon.domain.model.DiscountValue;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetCoupomUseCaseTest{
    private final CouponRepository repository = new CreateCouponUseCaseTest.InMemoryCouponRepository();
    private final GetCouponUseCase useCase = new GetCouponUseCase(repository);

    @Test
    void shouldReturnCoupon() {

        UUID id = UUID.randomUUID();
        Coupon coupon = Coupon.create(
                new CouponCode("ABC123"),
                "Cupom teste",
                new DiscountValue(BigDecimal.valueOf(0.2)),
                Instant.now().plusSeconds(3600),
                false
        );


        repository.save(coupon);

        CouponOutput output = useCase.execute(id);

        assertEquals("ABC123", output.getCode());
    }

}
