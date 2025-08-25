package io.github.eduardoafinacio.infrastructure.service;

import io.github.eduardoafinacio.core.domain.TransactionPin;
import io.github.eduardoafinacio.gateway.TransactionPinValidateGateway;
import io.github.eduardoafinacio.infrastructure.repository.TransactionPinEntityRepository;
import org.springframework.stereotype.Service;
import static io.github.eduardoafinacio.infrastructure.Utils.Utilities.log;

import java.util.Objects;

@Service
public class TransactionPinValidateGatewayImpl implements TransactionPinValidateGateway {
    private TransactionPinEntityRepository transactionPinEntityRepository;

    public TransactionPinValidateGatewayImpl(TransactionPinEntityRepository transactionPinEntityRepository) {
        this.transactionPinEntityRepository = transactionPinEntityRepository;
    }
    @Override
    public Boolean validate(TransactionPin transactionPin, String pin) {
        log.info("Inicio da validação da senha de transação::TransactionPinValidateGatewayImpl");
        if (!Objects.equals(transactionPin.getPin(), pin)){
            log.info("Senha incorreta::TransactionPinValidateGatewayImpl");
            return false;
        }
        log.info("Senha correta::TransactionPinValidateGatewayImpl");
        return true;
    }
}
