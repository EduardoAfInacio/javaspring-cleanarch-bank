package io.github.eduardoafinacio.gateway;

import io.github.eduardoafinacio.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceGateway {
    BigDecimal consult(Wallet wallet);
}
