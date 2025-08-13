package io.github.eduardoafinacio.usecaseimpl;

import io.github.eduardoafinacio.core.domain.Transaction;
import io.github.eduardoafinacio.core.exception.InternalServerErrorException;
import io.github.eduardoafinacio.core.exception.enums.ErrorCodeEnum;
import io.github.eduardoafinacio.gateway.TransactionValidateGateway;
import io.github.eduardoafinacio.usecase.TransactionValidateUseCase;

public class TransactionValidateUseCaseImpl implements TransactionValidateUseCase {
    private TransactionValidateGateway transactionValidateGateway;

    public TransactionValidateUseCaseImpl(TransactionValidateGateway transactionValidateGateway) {
        this.transactionValidateGateway = transactionValidateGateway;
    }
    @Override
    public Boolean validate(Transaction transaction) throws InternalServerErrorException{
        if(!transactionValidateGateway.validate(transaction)){
            throw new InternalServerErrorException(ErrorCodeEnum.TR0004.getMessage(), ErrorCodeEnum.TR0004.getCode());
        }
        return true;
    }
}
