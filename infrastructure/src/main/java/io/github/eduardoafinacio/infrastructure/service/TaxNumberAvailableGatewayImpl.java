package io.github.eduardoafinacio.infrastructure.service;

import io.github.eduardoafinacio.gateway.TaxNumberAvailableGateway;
import io.github.eduardoafinacio.infrastructure.repository.UserEntityRepository;
import static io.github.eduardoafinacio.infrastructure.Utils.Utilities.log;

public class TaxNumberAvailableGatewayImpl implements TaxNumberAvailableGateway {
    private UserEntityRepository userEntityRepository;

    public TaxNumberAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }
    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        log.info("Starting to check if tax number is available::TaxNumberAvailableGatewayImpl");
        return !userEntityRepository.existsByTaxNumber(taxNumber);
    }
}
