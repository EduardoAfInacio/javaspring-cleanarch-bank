package io.github.eduardoafinacio.usecaseimpl;

import io.github.eduardoafinacio.core.domain.User;
import io.github.eduardoafinacio.core.exception.EmailException;
import io.github.eduardoafinacio.core.exception.TaxNumberException;
import io.github.eduardoafinacio.core.exception.enums.ErrorCodeEnum;
import io.github.eduardoafinacio.usecase.CreateUserUseCase;
import io.github.eduardoafinacio.usecase.EmailAvailableUseCase;
import io.github.eduardoafinacio.usecase.TaxNumberAvailableUseCase;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private TaxNumberAvailableUseCase taxNumberAvailableUseCase;
    private EmailAvailableUseCase emailAvailableUseCase;

    public CreateUserUseCaseImpl(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
    }

    @Override
    public void create(User user) throws TaxNumberException, EmailException {
        if(!taxNumberAvailableUseCase.taxNumberAvailable(user.getTaxNumber().getValue())){
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        if(emailAvailableUseCase.emailAvailable(user.getEmail())){
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }
    }
}
