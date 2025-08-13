package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.domain.TransactionPin;

public interface TransactionPinValidateUseCase {
    Boolean validate(TransactionPin transactionPin);
}
