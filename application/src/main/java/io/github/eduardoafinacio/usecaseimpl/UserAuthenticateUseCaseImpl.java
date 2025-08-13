package io.github.eduardoafinacio.usecaseimpl;

import io.github.eduardoafinacio.core.exception.AuthenticationException;
import io.github.eduardoafinacio.core.exception.enums.ErrorCodeEnum;
import io.github.eduardoafinacio.gateway.UserAuthenticateGateway;
import io.github.eduardoafinacio.gateway.UserNotificationGateway;
import io.github.eduardoafinacio.usecase.UserAuthenticateUseCase;

public class UserAuthenticateUseCaseImpl implements UserAuthenticateUseCase {
    private UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticateUseCaseImpl(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }
    @Override
    public Boolean authenticate(String username, String password) throws AuthenticationException {
        if(!userAuthenticateGateway.authenticate(username, password)) {
            throw new AuthenticationException(ErrorCodeEnum.ATH0001.getMessage(), ErrorCodeEnum.ATH0001.getCode());
        }

        return true;
    }
}
