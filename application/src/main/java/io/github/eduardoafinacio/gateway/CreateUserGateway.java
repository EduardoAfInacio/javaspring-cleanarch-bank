package io.github.eduardoafinacio.gateway;

import io.github.eduardoafinacio.core.domain.User;

public interface CreateUserGateway {
    User create(User user);
}
