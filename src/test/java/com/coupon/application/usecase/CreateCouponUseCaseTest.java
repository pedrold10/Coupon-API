package com.coupon.application.usecase;

import com.coupon.application.dto.CouponOutput;
import com.coupon.application.dto.CreateCouponCommand;
import com.coupon.application.port.CouponRepository;
import com.coupon.domain.exception.InvalidExpirationDateException;
import com.coupon.domain.model.Coupon;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class CreateCouponUseCaseTest {

    private final CouponRepository repository = new InMemoryCouponRepository();
    private final CreateCouponUseCase useCase = new CreateCouponUseCase(repository);

    @Test
    void shouldCreateCouponSuccessfully() {
        CreateCouponCommand command = new CreateCouponCommand(
                "ABC-123",
                "Cupom de desconto",
                BigDecimal.valueOf(0.8),
                Instant.now().plusSeconds(3600),
                false
        );

        CouponOutput output = useCase.execute(command);

        assertNotNull(output.getId());
        assertEquals("ABC123", output.getCode());
        assertEquals(BigDecimal.valueOf(0.8), output.getDiscountValue());
        assertFalse(output.isPublished());
        assertFalse(output.isRedeemed());
    }

    @Test
    void shouldThrowExceptionWhenExpirationDateIsInPast() {
        CreateCouponCommand command = new CreateCouponCommand(
                "ABC123",
                "Cupom inválido",
                BigDecimal.valueOf(1.0),
                Instant.now().minusSeconds(3600),
                false
        );

        assertThrows(
                InvalidExpirationDateException.class,
                () -> useCase.execute(command)
        );
    }

    static class InMemoryCouponRepository implements CouponRepository {

        private final Map<UUID, Coupon> db = new HashMap<>();

        @Override
        public Coupon save(Coupon coupon) {
            db.put(coupon.getId(), coupon);
            return coupon;
        }

        @Override
        public Optional<Coupon> findById(UUID id) {
            return Optional.ofNullable(db.get(id));
        }
    }
}
