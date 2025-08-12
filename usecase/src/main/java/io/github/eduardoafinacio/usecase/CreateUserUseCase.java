package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.domain.User;
import io.github.eduardoafinacio.core.exception.EmailException;
import io.github.eduardoafinacio.core.exception.InternalServerErrorException;
import io.github.eduardoafinacio.core.exception.TaxNumberException;
import io.github.eduardoafinacio.core.exception.TransactionPinException;

public interface CreateUserUseCase {
    void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException;
}
