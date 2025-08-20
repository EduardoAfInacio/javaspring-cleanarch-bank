package io.github.eduardoafinacio.infrastructure.service;

import io.github.eduardoafinacio.core.domain.Wallet;
import io.github.eduardoafinacio.gateway.FindWalletByTaxNumberGateway;
import io.github.eduardoafinacio.infrastructure.repository.WalletEntityRepository;

public class FindWalletByTaxNumberGatewayImpl implements FindWalletByTaxNumberGateway {
    private WalletEntityRepository walletEntityRepository;

    public FindWalletByTaxNumberGatewayImpl(WalletEntityRepository walletEntityRepository) {
        this.walletEntityRepository = walletEntityRepository;
    }
    @Override
    public Wallet findByTaxNumber(String taxNumber) {
        return null;
    }
}
