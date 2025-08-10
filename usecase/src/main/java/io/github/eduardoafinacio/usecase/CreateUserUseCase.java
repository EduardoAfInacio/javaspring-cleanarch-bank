package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.domain.User;
import io.github.eduardoafinacio.core.exception.EmailException;
import io.github.eduardoafinacio.core.exception.TaxNumberException;

public interface CreateUserUseCase {
    void create(User user) throws TaxNumberException, EmailException;
}
