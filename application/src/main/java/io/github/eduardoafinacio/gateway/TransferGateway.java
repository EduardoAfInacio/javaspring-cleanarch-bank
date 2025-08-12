package io.github.eduardoafinacio.gateway;

import io.github.eduardoafinacio.core.domain.Transaction;

public interface TransferGateway {
    Boolean transfer(Transaction transaction);
}
