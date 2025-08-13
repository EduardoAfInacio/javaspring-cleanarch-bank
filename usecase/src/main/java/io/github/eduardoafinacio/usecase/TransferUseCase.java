package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.exception.InternalServerErrorException;
import io.github.eduardoafinacio.core.exception.NotFoundException;
import io.github.eduardoafinacio.core.exception.NotificationException;
import io.github.eduardoafinacio.core.exception.TransferException;

import java.math.BigDecimal;

public interface TransferUseCase {
    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin) throws TransferException, NotFoundException, NotificationException, InternalServerErrorException;
}
