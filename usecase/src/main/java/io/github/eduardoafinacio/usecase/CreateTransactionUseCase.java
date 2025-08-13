package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.domain.Transaction;
import io.github.eduardoafinacio.core.exception.TransferException;

public interface CreateTransactionUseCase {
    Transaction create(Transaction transaction) throws TransferException;
}
