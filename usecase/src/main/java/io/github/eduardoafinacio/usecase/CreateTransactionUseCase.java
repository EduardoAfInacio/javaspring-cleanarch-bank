package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.domain.Transaction;

public interface CreateTransactionUseCase {
    Transaction create(Transaction transaction);
}
