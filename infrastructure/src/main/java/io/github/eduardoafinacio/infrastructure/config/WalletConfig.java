package io.github.eduardoafinacio.infrastructure.config;

import io.github.eduardoafinacio.gateway.FindWalletByTaxNumberGateway;
import io.github.eduardoafinacio.usecase.ConsultBalanceUseCase;
import io.github.eduardoafinacio.usecase.FindWalletByTaxNumberUseCase;
import io.github.eduardoafinacio.usecaseimpl.ConsultBalanceUseCaseImpl;
import io.github.eduardoafinacio.usecaseimpl.FindWalletByTaxNumberUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WalletConfig {
    @Bean
    public FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway){
        return new FindWalletByTaxNumberUseCaseImpl(findWalletByTaxNumberGateway);
    }

    @Bean
    public ConsultBalanceUseCase consultBalanceUseCase(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase){
        return new ConsultBalanceUseCaseImpl(findWalletByTaxNumberUseCase);
    }
}
