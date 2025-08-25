package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.domain.Transaction;
import io.github.eduardoafinacio.core.domain.User;
import io.github.eduardoafinacio.core.exception.*;

import java.math.BigDecimal;

public interface TransferUseCase {
    Boolean transfer(Transaction transaction) throws TransferException, NotFoundException, NotificationException, InternalServerErrorException, TransactionPinException, TaxNumberException;
}
