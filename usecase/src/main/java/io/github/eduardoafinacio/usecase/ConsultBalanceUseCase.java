package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.domain.Wallet;
import io.github.eduardoafinacio.core.exception.NotFoundException;
import io.github.eduardoafinacio.core.exception.TaxNumberException;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {
    BigDecimal consult(String taxNumber) throws TaxNumberException, NotFoundException;
}
