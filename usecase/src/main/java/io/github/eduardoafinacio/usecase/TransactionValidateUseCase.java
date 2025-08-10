package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.domain.Transaction;

public interface TransactionValidateUseCase {
    Boolean validate(Transaction transaction);
}
