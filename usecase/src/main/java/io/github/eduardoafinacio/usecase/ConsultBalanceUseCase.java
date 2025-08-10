package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {
    BigDecimal consult(Wallet wallet);
}
