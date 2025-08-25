package io.github.eduardoafinacio.gateway;

import io.github.eduardoafinacio.core.domain.TransactionPin;

public interface TransactionPinValidateGateway {
    Boolean validate(TransactionPin transactionPin, String pin);
}
