package io.github.eduardoafinacio.usecaseimpl;

import io.github.eduardoafinacio.core.domain.TransactionPin;
import io.github.eduardoafinacio.core.domain.User;
import io.github.eduardoafinacio.core.domain.Wallet;
import io.github.eduardoafinacio.core.exception.EmailException;
import io.github.eduardoafinacio.core.exception.InternalServerErrorException;
import io.github.eduardoafinacio.core.exception.TaxNumberException;
import io.github.eduardoafinacio.core.exception.TransactionPinException;
import io.github.eduardoafinacio.core.exception.enums.ErrorCodeEnum;
import io.github.eduardoafinacio.gateway.CreateUserGateway;
import io.github.eduardoafinacio.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(CreateUserGateway createUserGateway) {
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException {

        if(!createUserGateway.create(user, new Wallet(new TransactionPin(pin), BigDecimal.ZERO, user))){
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }

    }
}
