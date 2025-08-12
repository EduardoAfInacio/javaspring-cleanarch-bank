package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.domain.Wallet;

public interface FindWalletByTaxNumberUseCase {
    Wallet findByTaxNumber(String taxNumber);
}
