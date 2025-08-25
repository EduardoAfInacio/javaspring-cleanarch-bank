package io.github.eduardoafinacio.infrastructure.service;

import io.github.eduardoafinacio.core.domain.TransactionPin;
import io.github.eduardoafinacio.gateway.UpdateTransactionPinGateway;
import org.springframework.stereotype.Service;

@Service
public class UpdateTransactionPinGatewayImpl implements UpdateTransactionPinGateway {
    @Override
    public TransactionPin update(TransactionPin transactionPin) {
        return new TransactionPin(transactionPin.getId(), transactionPin.getPin(), transactionPin.getAttempt(), transactionPin.getBlocked(), transactionPin.getCreatedAt(), transactionPin.getUpdatedAt());
    }
}
