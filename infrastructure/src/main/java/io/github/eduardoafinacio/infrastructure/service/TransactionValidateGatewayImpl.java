package io.github.eduardoafinacio.infrastructure.service;

import io.github.eduardoafinacio.core.domain.Transaction;
import io.github.eduardoafinacio.gateway.TransactionValidateGateway;
import io.github.eduardoafinacio.infrastructure.client.ApiValidateService;
import org.springframework.stereotype.Service;

@Service
public class TransactionValidateGatewayImpl implements TransactionValidateGateway {
    private ApiValidateService apiValidateService;

    public TransactionValidateGatewayImpl(ApiValidateService apiValidateService) {
        this.apiValidateService = apiValidateService;
    }
    @Override
    public Boolean validate(Transaction transaction) {
        var response = apiValidateService.validate();
        if(response == null) return false;
        return response.success();
    }
}
