package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.exception.*;

import java.math.BigDecimal;

public interface TransferUseCase {
    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin) throws TransferException, NotFoundException, NotificationException, InternalServerErrorException, TransactionPinException, TaxNumberException;
}
