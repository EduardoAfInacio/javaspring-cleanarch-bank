package io.github.eduardoafinacio.usecaseimpl;

import io.github.eduardoafinacio.core.domain.Wallet;
import io.github.eduardoafinacio.core.exception.NotFoundException;
import io.github.eduardoafinacio.core.exception.TaxNumberException;
import io.github.eduardoafinacio.core.exception.enums.ErrorCodeEnum;
import io.github.eduardoafinacio.gateway.FindWalletByTaxNumberGateway;
import io.github.eduardoafinacio.usecase.FindWalletByTaxNumberUseCase;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {
    private FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberUseCaseImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        this.findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }
    @Override
    public Wallet findByTaxNumber(String taxNumber) throws NotFoundException, TaxNumberException {
        var wallet = findWalletByTaxNumberGateway.findByTaxNumber(taxNumber);
        if(wallet == null) {
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }
        return wallet;
    }
}
