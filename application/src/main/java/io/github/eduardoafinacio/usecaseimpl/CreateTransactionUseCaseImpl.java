package io.github.eduardoafinacio.usecaseimpl;

import io.github.eduardoafinacio.core.domain.Transaction;
import io.github.eduardoafinacio.core.exception.TaxNumberException;
import io.github.eduardoafinacio.core.exception.TransferException;
import io.github.eduardoafinacio.core.exception.enums.ErrorCodeEnum;
import io.github.eduardoafinacio.gateway.CreateTransactionGateway;
import io.github.eduardoafinacio.usecase.CreateTransactionUseCase;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {
    private CreateTransactionGateway createTransactionGateway;

    public CreateTransactionUseCaseImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }
    @Override
    public Transaction create(Transaction transaction) throws TransferException, TaxNumberException {
        var transactionSaved = createTransactionGateway.create(transaction);
        if(transactionSaved == null) {
            throw new TransferException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        return transactionSaved;
    }
}
