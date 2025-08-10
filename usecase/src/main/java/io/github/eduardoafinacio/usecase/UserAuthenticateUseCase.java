package io.github.eduardoafinacio.usecase;

public interface UserAuthenticateUseCase {
    Boolean authenticate(String username, String password);
}
