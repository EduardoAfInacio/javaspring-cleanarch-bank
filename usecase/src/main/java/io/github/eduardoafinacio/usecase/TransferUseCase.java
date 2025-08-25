package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.domain.Transaction;
import io.github.eduardoafinacio.core.exception.*;

public interface TransferUseCase {
    Boolean transfer(Transaction transaction) throws TransferException, NotFoundException, NotificationException, InternalServerErrorException, TransactionPinException, TaxNumberException;
}
