package io.github.eduardoafinacio.usecaseimpl;

import io.github.eduardoafinacio.core.domain.Transaction;
import io.github.eduardoafinacio.core.domain.Wallet;
import io.github.eduardoafinacio.core.exception.TransferException;
import io.github.eduardoafinacio.core.exception.enums.ErrorCodeEnum;
import io.github.eduardoafinacio.gateway.TransferGateway;
import io.github.eduardoafinacio.usecase.CreateTransactionUseCase;
import io.github.eduardoafinacio.usecase.FindWalletByTaxNumberUseCase;
import io.github.eduardoafinacio.usecase.TransactionValidateUseCase;
import io.github.eduardoafinacio.usecase.TransferUseCase;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {
    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private CreateTransactionUseCase createTransactionUseCase;
    private TransactionValidateUseCase transactionValidateUseCase;
    private TransferGateway transferGateway;

    public TransferUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, CreateTransactionUseCase createTransactionUseCase, TransactionValidateUseCase transactionValidateUseCase, TransferGateway transferGateway) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.transferGateway = transferGateway;
    }
    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws TransferException{
        Wallet from = findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);

        var transaction = createTransactionUseCase.create(new Transaction(from, to, value));

        if(transactionValidateUseCase.validate(transaction)) {
            if(!transferGateway.transfer(transaction))
                throw new TransferException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        return true;
    }
}
