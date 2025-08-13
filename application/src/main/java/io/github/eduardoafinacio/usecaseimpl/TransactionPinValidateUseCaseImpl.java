package io.github.eduardoafinacio.usecaseimpl;

import io.github.eduardoafinacio.core.domain.TransactionPin;
import io.github.eduardoafinacio.core.exception.TransactionPinException;
import io.github.eduardoafinacio.core.exception.enums.ErrorCodeEnum;
import io.github.eduardoafinacio.gateway.TransactionPinValidateGateway;
import io.github.eduardoafinacio.usecase.TransactionPinValidateUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {
    private TransactionPinValidateGateway transactionPinValidateGateway;

    public TransactionPinValidateUseCaseImpl(TransactionPinValidateGateway transactionPinValidateGateway) {
        this.transactionPinValidateGateway = transactionPinValidateGateway;
    }
    @Override
    public void validate(TransactionPin transactionPin) throws TransactionPinException{
        if(!transactionPinValidateGateway.validate(transactionPin)) {
            throw new TransactionPinException(ErrorCodeEnum.TRP0003.getMessage(), ErrorCodeEnum.TRP0003.getCode());
        }
    }
}
