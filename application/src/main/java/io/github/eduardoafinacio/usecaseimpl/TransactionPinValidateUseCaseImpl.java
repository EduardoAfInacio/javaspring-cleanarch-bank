package io.github.eduardoafinacio.usecaseimpl;

import io.github.eduardoafinacio.core.domain.TransactionPin;
import io.github.eduardoafinacio.core.exception.TransactionPinException;
import io.github.eduardoafinacio.core.exception.enums.ErrorCodeEnum;
import io.github.eduardoafinacio.gateway.TransactionPinValidateGateway;
import io.github.eduardoafinacio.usecase.TransactionPinValidateUseCase;
import io.github.eduardoafinacio.usecase.UpdateTransactionPinUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {
    private TransactionPinValidateGateway transactionPinValidateGateway;
    private UpdateTransactionPinUseCase updateTransactionPinUseCase;

    public TransactionPinValidateUseCaseImpl(TransactionPinValidateGateway transactionPinValidateGateway, UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        this.transactionPinValidateGateway = transactionPinValidateGateway;
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
    }
    @Override
    public Boolean validate(TransactionPin transactionPin) throws TransactionPinException{

        if(transactionPin.getBlocked()){
            throw new TransactionPinException(ErrorCodeEnum.TRP0002.getMessage(), ErrorCodeEnum.TRP0002.getCode());
        }

        if(!transactionPinValidateGateway.validate(transactionPin)) {
            transactionPin.setAttempt();
            var transactionPinUpdated = updateTransactionPinUseCase.update(transactionPin);
            throw new TransactionPinException(ErrorCodeEnum.TRP0003getMessage(transactionPinUpdated.getAttempt()), ErrorCodeEnum.TRP0003.getCode());
        }

        if(transactionPin.getAttempt() < 3){
            transactionPin.resetAttempt();
            updateTransactionPinUseCase.update(transactionPin);
        }

        return true;
    }
}
