package com.coupon.application.usecase;

import com.coupon.application.port.CouponRepository;
import com.coupon.domain.exception.CouponNotFoundException;
import com.coupon.domain.model.Coupon;
import com.coupon.domain.model.CouponCode;
import com.coupon.domain.model.DiscountValue;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeleteCouponUseCaseTest {
    private final CouponRepository repository = new CreateCouponUseCaseTest.InMemoryCouponRepository();
    private final DeleteCouponUseCase useCase = new DeleteCouponUseCase(repository);

    @Test
    void shouldDeleteCouponSuccessfully() {
        Coupon coupon = Coupon.create(
                new CouponCode("ABC123"),
                "Cupom teste",
                new DiscountValue(BigDecimal.valueOf(0.2)),
                Instant.now().plusSeconds(3600),
                false
        );
        repository.save(coupon);

        useCase.execute(coupon.getId());

        assertTrue(repository.findById(coupon.getId()).isEmpty());
    }

    @Test
    void shouldThrowWhenCouponNotFound() {
        assertThrows(CouponNotFoundException.class,
                () -> useCase.execute(UUID.randomUUID()));
    }
}
