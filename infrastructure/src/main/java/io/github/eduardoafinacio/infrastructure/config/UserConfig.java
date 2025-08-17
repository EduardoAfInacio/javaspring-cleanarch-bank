package io.github.eduardoafinacio.infrastructure.config;

import io.github.eduardoafinacio.gateway.CreateUserGateway;
import io.github.eduardoafinacio.gateway.EmailAvailableGateway;
import io.github.eduardoafinacio.gateway.TaxNumberAvailableGateway;
import io.github.eduardoafinacio.usecase.EmailAvailableUseCase;
import io.github.eduardoafinacio.usecase.TaxNumberAvailableUseCase;
import io.github.eduardoafinacio.usecaseimpl.CreateUserUseCaseImpl;
import io.github.eduardoafinacio.usecaseimpl.EmailAvailableUseCaseImpl;
import io.github.eduardoafinacio.usecaseimpl.TaxNumberAvailableUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public TaxNumberAvailableUseCase taxNumberAvailableUseCase(TaxNumberAvailableGateway taxNumberAvailableGateway){
        return new TaxNumberAvailableUseCaseImpl(taxNumberAvailableGateway);
    }

    @Bean
    public EmailAvailableUseCase emailAvailableUseCase(EmailAvailableGateway emailAvailableGateway){
        return new EmailAvailableUseCaseImpl(emailAvailableGateway);
    }

    @Bean
    public CreateUserUseCaseImpl createUserUseCase(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway){
        return new CreateUserUseCaseImpl(taxNumberAvailableUseCase, emailAvailableUseCase, createUserGateway);
    }
}
