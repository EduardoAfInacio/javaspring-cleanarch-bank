package io.github.eduardoafinacio.usecaseimpl;

import io.github.eduardoafinacio.core.domain.Wallet;
import io.github.eduardoafinacio.core.exception.NotFoundException;
import io.github.eduardoafinacio.core.exception.TaxNumberException;
import io.github.eduardoafinacio.gateway.ConsultBalanceGateway;
import io.github.eduardoafinacio.usecase.ConsultBalanceUseCase;
import io.github.eduardoafinacio.usecase.FindWalletByTaxNumberUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCaseImpl implements ConsultBalanceUseCase {
    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;

    public ConsultBalanceUseCaseImpl(ConsultBalanceGateway consultBalanceGateway, FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
    }

    @Override
    public BigDecimal consult(String taxNumber) throws TaxNumberException, NotFoundException {
        var wallet = findWalletByTaxNumberUseCase.findByTaxNumber(taxNumber);
        return wallet.getBalance();
    }
}
