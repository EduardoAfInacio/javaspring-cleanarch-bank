package io.github.eduardoafinacio.gateway;

import io.github.eduardoafinacio.core.domain.TransactionPin;

public interface CreateTransactionPinGateway {
    void create(TransactionPin transactionPin);
}
