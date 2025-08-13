package io.github.eduardoafinacio.usecaseimpl;

import io.github.eduardoafinacio.core.domain.TransactionPin;
import io.github.eduardoafinacio.gateway.UpdateTransactionPinGateway;
import io.github.eduardoafinacio.usecase.UpdateTransactionPinUseCase;

public class UpdateTransactionPinUseCaseImpl implements UpdateTransactionPinUseCase {
    private UpdateTransactionPinGateway updateTransactionPinGateway;

    public UpdateTransactionPinUseCaseImpl(UpdateTransactionPinGateway updateTransactionPinGateway) {
        this.updateTransactionPinGateway = updateTransactionPinGateway;
    }
    @Override
    public TransactionPin update(TransactionPin transactionPin) {
        return updateTransactionPinGateway.update(transactionPin);
    }
}
