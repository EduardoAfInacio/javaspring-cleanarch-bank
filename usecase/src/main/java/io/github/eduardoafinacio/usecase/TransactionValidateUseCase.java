package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.domain.Transaction;
import io.github.eduardoafinacio.core.exception.InternalServerErrorException;

public interface TransactionValidateUseCase {
    Boolean validate(Transaction transaction) throws InternalServerErrorException;
}
