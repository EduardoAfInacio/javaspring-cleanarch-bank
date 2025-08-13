package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.domain.TransactionPin;
import io.github.eduardoafinacio.core.exception.TransactionPinException;

public interface TransactionPinValidateUseCase {
    Boolean validate(TransactionPin transactionPin) throws TransactionPinException;
}
