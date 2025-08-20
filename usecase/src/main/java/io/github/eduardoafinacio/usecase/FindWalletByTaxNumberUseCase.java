package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.domain.Wallet;
import io.github.eduardoafinacio.core.exception.NotFoundException;
import io.github.eduardoafinacio.core.exception.TaxNumberException;

public interface FindWalletByTaxNumberUseCase {
    Wallet findByTaxNumber(String taxNumber) throws NotFoundException, TaxNumberException;
}
