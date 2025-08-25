package io.github.eduardoafinacio.usecaseimpl;

import io.github.eduardoafinacio.core.domain.Transaction;
import io.github.eduardoafinacio.core.domain.Wallet;
import io.github.eduardoafinacio.core.exception.*;
import io.github.eduardoafinacio.core.exception.enums.ErrorCodeEnum;
import io.github.eduardoafinacio.gateway.TransferGateway;
import io.github.eduardoafinacio.usecase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {
    private TransferGateway transferGateway;

    public TransferUseCaseImpl(TransferGateway transferGateway) {
        this.transferGateway = transferGateway;
    }
    @Override
    public Boolean transfer(Transaction transaction) throws TransferException, NotFoundException, NotificationException, InternalServerErrorException, TransactionPinException, TaxNumberException {

        transaction.getFromWallet().transferValue(transaction.getValue());
        transaction.getToWallet().receiveValue(transaction.getValue());


        if(!transferGateway.transfer(transaction)){
            throw new TransferException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        return true;
    }
}
