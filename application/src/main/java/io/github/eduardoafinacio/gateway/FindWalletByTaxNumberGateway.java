package io.github.eduardoafinacio.gateway;

import io.github.eduardoafinacio.core.domain.Wallet;
import io.github.eduardoafinacio.core.exception.TaxNumberException;

public interface FindWalletByTaxNumberGateway {
    Wallet findByTaxNumber(String taxNumber) throws TaxNumberException;
}
