package io.github.eduardoafinacio.infrastructure.service;

import io.github.eduardoafinacio.core.domain.Wallet;
import io.github.eduardoafinacio.core.exception.TaxNumberException;
import io.github.eduardoafinacio.gateway.FindWalletByTaxNumberGateway;
import io.github.eduardoafinacio.infrastructure.mapper.WalletMapper;
import io.github.eduardoafinacio.infrastructure.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class FindWalletByTaxNumberGatewayImpl implements FindWalletByTaxNumberGateway {
    private WalletEntityRepository walletEntityRepository;
    private WalletMapper walletMapper;

    public FindWalletByTaxNumberGatewayImpl(WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }
    @Override
    public Wallet findByTaxNumber(String taxNumber) throws TaxNumberException {
        return walletMapper.toWallet(walletEntityRepository.findByUserEntityTaxNumber(taxNumber));
    }
}
