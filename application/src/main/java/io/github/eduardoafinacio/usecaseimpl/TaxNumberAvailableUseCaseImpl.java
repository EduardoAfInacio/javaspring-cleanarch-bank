package io.github.eduardoafinacio.usecaseimpl;

import io.github.eduardoafinacio.core.exception.TaxNumberException;
import io.github.eduardoafinacio.core.exception.enums.ErrorCodeEnum;
import io.github.eduardoafinacio.gateway.TaxNumberAvailableGateway;
import io.github.eduardoafinacio.usecase.TaxNumberAvailableUseCase;

public class TaxNumberAvailableUseCaseImpl implements TaxNumberAvailableUseCase {
    private TaxNumberAvailableGateway taxNumberAvailableGateway;

    public TaxNumberAvailableUseCaseImpl(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        this.taxNumberAvailableGateway = taxNumberAvailableGateway;
    }
    @Override
    public Boolean taxNumberAvailable(String taxNumber) throws TaxNumberException {
        if(!taxNumberAvailableGateway.taxNumberAvailable(taxNumber)){
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        return true;
    }
}
