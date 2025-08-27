package io.github.eduardoafinacio.usecaseimpl;


import io.github.eduardoafinacio.core.exception.EmailException;
import io.github.eduardoafinacio.core.exception.enums.ErrorCodeEnum;
import io.github.eduardoafinacio.gateway.EmailAvailableGateway;
import io.github.eduardoafinacio.usecase.EmailAvailableUseCase;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase {
    private EmailAvailableGateway emailAvailableGateway;

    public EmailAvailableUseCaseImpl(EmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }
    @Override
    public Boolean emailAvailable(String email) throws EmailException {
        if(!emailAvailableGateway.emailAvailable(email)){
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        return true;
    }
}
