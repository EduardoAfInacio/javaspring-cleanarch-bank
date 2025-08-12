package io.github.eduardoafinacio.gateway;

import io.github.eduardoafinacio.core.domain.Wallet;

public interface CreateWalletGateway {
    void create(Wallet wallet);
}
