package io.github.eduardoafinacio.gateway;

public interface UserAuthenticateGateway {
    Boolean authenticate(String username, String password);
}
