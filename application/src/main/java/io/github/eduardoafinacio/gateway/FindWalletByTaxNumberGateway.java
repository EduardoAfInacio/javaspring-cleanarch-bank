package io.github.eduardoafinacio.gateway;

import io.github.eduardoafinacio.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {
    Wallet findByTaxNumber(String taxNumber);
}
