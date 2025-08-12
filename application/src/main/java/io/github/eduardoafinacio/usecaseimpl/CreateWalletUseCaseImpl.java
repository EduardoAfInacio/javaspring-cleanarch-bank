package io.github.eduardoafinacio.usecaseimpl;

import io.github.eduardoafinacio.core.domain.Wallet;
import io.github.eduardoafinacio.gateway.CreateWalletGateway;
import io.github.eduardoafinacio.usecase.CreateWalletUseCase;

public class CreateWalletUseCaseImpl implements CreateWalletUseCase {
    private CreateWalletGateway createWalletGateway;

    public CreateWalletUseCaseImpl(CreateWalletGateway createWalletGateway) {
        this.createWalletGateway = createWalletGateway;
    }
    @Override
    public void create(Wallet wallet) {
        createWalletGateway.create(wallet);
    }
}
