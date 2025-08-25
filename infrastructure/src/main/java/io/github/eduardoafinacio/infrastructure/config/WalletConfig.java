package io.github.eduardoafinacio.infrastructure.config;

import io.github.eduardoafinacio.gateway.*;
import io.github.eduardoafinacio.usecase.*;
import io.github.eduardoafinacio.usecaseimpl.*;
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

    @Bean
    public UpdateTransactionPinUseCase updateTransactionPinUseCase(UpdateTransactionPinGateway updateTransactionPinGateway){
        return new UpdateTransactionPinUseCaseImpl(updateTransactionPinGateway);
    }

    @Bean
    public TransactionPinValidateUseCase transactionPinValidateUseCase(TransactionPinValidateGateway transactionPinValidateGateway, UpdateTransactionPinUseCase updateTransactionPinUseCase){
        return new TransactionPinValidateUseCaseImpl(transactionPinValidateGateway, updateTransactionPinUseCase);
    }

    @Bean
    public UserNotificationUseCase userNotificationUseCase(UserNotificationGateway userNotificationGateway){
        return new UserNotificationUseCaseImpl(userNotificationGateway);
    }

    @Bean
    public TransactionValidateUseCase transactionValidateUseCase(TransactionValidateGateway transactionValidateGateway){
        return new TransactionValidateUseCaseImpl(transactionValidateGateway);
    }

    @Bean
    public CreateTransactionUseCase createTransactionUseCase(CreateTransactionGateway createTransactionGateway){
        return new CreateTransactionUseCaseImpl(createTransactionGateway);
    }

    @Bean
    public TransferUseCase transferUseCase(TransferGateway transferGateway){
        return new TransferUseCaseImpl(transferGateway);
    }
}
