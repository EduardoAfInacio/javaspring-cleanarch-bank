package io.github.eduardoafinacio.gateway;

import io.github.eduardoafinacio.core.domain.Transaction;

public interface TransactionValidateGateway {
    Boolean validate(Transaction transaction);
}
