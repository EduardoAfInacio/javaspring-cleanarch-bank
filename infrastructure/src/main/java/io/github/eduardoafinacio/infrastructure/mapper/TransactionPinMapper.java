package io.github.eduardoafinacio.infrastructure.mapper;

import io.github.eduardoafinacio.core.domain.TransactionPin;
import io.github.eduardoafinacio.infrastructure.entity.TransactionPinEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionPinMapper {
    public TransactionPinEntity toTransactionPinEntity(TransactionPin transactionPin){
        return new TransactionPinEntity(
                transactionPin.getPin(),
                transactionPin.getAttempt(),
                transactionPin.getBlocked(),
                transactionPin.getCreatedAt(),
                transactionPin.getUpdatedAt()
        );
    }
}
