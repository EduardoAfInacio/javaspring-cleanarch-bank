package io.github.eduardoafinacio.infrastructure.service;

import io.github.eduardoafinacio.core.domain.TransactionPin;
import io.github.eduardoafinacio.gateway.TransactionPinValidateGateway;
import io.github.eduardoafinacio.infrastructure.repository.TransactionPinEntityRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TransactionPinValidateGatewayImpl implements TransactionPinValidateGateway {
    private TransactionPinEntityRepository transactionPinEntityRepository;

    public TransactionPinValidateGatewayImpl(TransactionPinEntityRepository transactionPinEntityRepository) {
        this.transactionPinEntityRepository = transactionPinEntityRepository;
    }
    @Override
    public Boolean validate(TransactionPin transactionPin) {
        return transactionPinEntityRepository.findById(transactionPin.getId())
                .map(found -> Objects.equals(found.getPin(), transactionPin.getPin()))
                .orElse(false);
    }
}
