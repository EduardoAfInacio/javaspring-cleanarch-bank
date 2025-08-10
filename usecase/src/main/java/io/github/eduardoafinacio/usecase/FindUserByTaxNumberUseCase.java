package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.domain.User;

public interface FindUserByTaxNumberUseCase {
    User findByTaxNumber(String taxNumber);
}
