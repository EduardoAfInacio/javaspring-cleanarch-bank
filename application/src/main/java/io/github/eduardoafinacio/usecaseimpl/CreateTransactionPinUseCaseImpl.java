package io.github.eduardoafinacio.usecaseimpl;

import io.github.eduardoafinacio.core.domain.TransactionPin;
import io.github.eduardoafinacio.gateway.CreateTransactionPinGateway;
import io.github.eduardoafinacio.usecase.CreateTransactionPinUseCase;

public class CreateTransactionPinUseCaseImpl implements CreateTransactionPinUseCase {
    private CreateTransactionPinGateway createTransactionPinGateway;

    public CreateTransactionPinUseCaseImpl(CreateTransactionPinGateway createTransactionPinGateway) {
        this.createTransactionPinGateway = createTransactionPinGateway;
    }
    @Override
    public void create(TransactionPin transactionPin) {
        createTransactionPinGateway.create(transactionPin);
    }
}
