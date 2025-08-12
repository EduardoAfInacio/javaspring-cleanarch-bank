package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.exception.NotFoundException;
import io.github.eduardoafinacio.core.exception.NotificationException;
import io.github.eduardoafinacio.core.exception.TransferException;

import java.math.BigDecimal;

public interface TransferUseCase {
    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws TransferException, NotFoundException, NotificationException;
}
