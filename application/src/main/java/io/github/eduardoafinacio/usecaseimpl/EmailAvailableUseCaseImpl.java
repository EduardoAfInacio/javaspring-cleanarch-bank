package io.github.eduardoafinacio.usecaseimpl;


import io.github.eduardoafinacio.gateway.EmailAvailableGateway;
import io.github.eduardoafinacio.usecase.EmailAvailableUseCase;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase {
    private EmailAvailableGateway emailAvailableGateway;

    public EmailAvailableUseCaseImpl(EmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }
    @Override
    public Boolean emailAvailable(String email) {
        return emailAvailableGateway.emailAvailable(email);
    }
}
