package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.exception.AuthenticationException;

public interface UserAuthenticateUseCase {
    Boolean authenticate(String username, String password) throws AuthenticationException;
}
