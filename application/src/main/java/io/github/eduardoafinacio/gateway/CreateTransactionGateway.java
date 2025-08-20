package io.github.eduardoafinacio.gateway;

import io.github.eduardoafinacio.core.domain.Transaction;
import io.github.eduardoafinacio.core.exception.TaxNumberException;

public interface CreateTransactionGateway {
    Transaction create(Transaction transaction) throws TaxNumberException;
}
