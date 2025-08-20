package io.github.eduardoafinacio.usecaseimpl;

import io.github.eduardoafinacio.core.domain.Transaction;
import io.github.eduardoafinacio.core.domain.Wallet;
import io.github.eduardoafinacio.core.exception.*;
import io.github.eduardoafinacio.core.exception.enums.ErrorCodeEnum;
import io.github.eduardoafinacio.gateway.TransferGateway;
import io.github.eduardoafinacio.usecase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {
    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private CreateTransactionUseCase createTransactionUseCase;
    private TransactionValidateUseCase transactionValidateUseCase;
    private TransferGateway transferGateway;
    private UserNotificationUseCase userNotificationUseCase;
    private TransactionPinValidateUseCase transactionPinValidateUseCase;

    public TransferUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, CreateTransactionUseCase createTransactionUseCase, TransactionValidateUseCase transactionValidateUseCase, TransferGateway transferGateway, UserNotificationUseCase userNotificationUseCase, TransactionPinValidateUseCase transactionPinValidateUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.transferGateway = transferGateway;
        this.userNotificationUseCase = userNotificationUseCase;
        this.transactionPinValidateUseCase = transactionPinValidateUseCase;
    }
    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin) throws TransferException, NotFoundException, NotificationException, InternalServerErrorException, TransactionPinException, TaxNumberException {
        Wallet from = findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);

        transactionPinValidateUseCase.validate(from.getTransactionPin());

        from.transferValue(value);
        to.receiveValue(value);

        var transaction = createTransactionUseCase.create(new Transaction(from, to, value));

        if(transactionValidateUseCase.validate(transaction)) {
            if(!transferGateway.transfer(transaction))
                throw new TransferException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        if(!userNotificationUseCase.notificate(transaction, to.getUser().getEmail())){
            throw new NotificationException(ErrorCodeEnum.NO0001.getMessage(), ErrorCodeEnum.NO0001.getCode());
        }

        return true;
    }
}
