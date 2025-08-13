package io.github.eduardoafinacio.gateway;

import io.github.eduardoafinacio.core.domain.TransactionPin;
import io.github.eduardoafinacio.core.domain.User;
import io.github.eduardoafinacio.core.domain.Wallet;

public interface CreateUserGateway {
    Boolean create(User user, Wallet wallet);
}
