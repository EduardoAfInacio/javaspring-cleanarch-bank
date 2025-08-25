package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.domain.Transaction;
import io.github.eduardoafinacio.core.domain.Wallet;
import io.github.eduardoafinacio.core.exception.TaxNumberException;
import io.github.eduardoafinacio.core.exception.TransferException;

import java.math.BigDecimal;

public interface CreateTransactionUseCase {
    Transaction create(Wallet from, Wallet to, BigDecimal value) throws TransferException, TaxNumberException;
}
