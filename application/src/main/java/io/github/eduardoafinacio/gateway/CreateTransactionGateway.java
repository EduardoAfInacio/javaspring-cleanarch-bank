package io.github.eduardoafinacio.gateway;

import io.github.eduardoafinacio.core.domain.Transaction;

public interface CreateTransactionGateway {
    Transaction create(Transaction transaction);
}
