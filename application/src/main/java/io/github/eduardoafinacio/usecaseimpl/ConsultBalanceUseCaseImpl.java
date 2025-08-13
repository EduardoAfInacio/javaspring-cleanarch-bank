package io.github.eduardoafinacio.usecaseimpl;

import io.github.eduardoafinacio.core.domain.Wallet;
import io.github.eduardoafinacio.gateway.ConsultBalanceGateway;
import io.github.eduardoafinacio.usecase.ConsultBalanceUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCaseImpl implements ConsultBalanceUseCase {
    private ConsultBalanceGateway consultBalanceGateway;

    public ConsultBalanceUseCaseImpl(ConsultBalanceGateway consultBalanceGateway) {
        this.consultBalanceGateway = consultBalanceGateway;
    }

    @Override
    public BigDecimal consult(Wallet wallet) {
        return consultBalanceGateway.consult(wallet);
    }
}
