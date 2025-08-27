package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.exception.TaxNumberException;

public interface TaxNumberAvailableUseCase {
    Boolean taxNumberAvailable(String taxNumber) throws TaxNumberException;
}
