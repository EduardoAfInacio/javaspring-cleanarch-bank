package io.github.eduardoafinacio.infrastructure.service;

import io.github.eduardoafinacio.core.domain.TransactionPin;
import io.github.eduardoafinacio.gateway.UpdateTransactionPinGateway;
import org.springframework.stereotype.Service;

@Service
public class UpdateTransactionPinGatewayImpl implements UpdateTransactionPinGateway {
    @Override
    public TransactionPin update(TransactionPin transactionPin) {
        return null;
    }
}
