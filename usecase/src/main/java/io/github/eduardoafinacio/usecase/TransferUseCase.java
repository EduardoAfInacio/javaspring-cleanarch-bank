package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.domain.Transaction;

import java.math.BigDecimal;

public interface TransferUseCase {
    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value);
}
