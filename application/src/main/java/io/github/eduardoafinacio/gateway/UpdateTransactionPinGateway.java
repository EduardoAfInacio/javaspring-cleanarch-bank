package io.github.eduardoafinacio.gateway;

import io.github.eduardoafinacio.core.domain.TransactionPin;

public interface UpdateTransactionPinGateway {
    TransactionPin update(TransactionPin transactionPin);
}
