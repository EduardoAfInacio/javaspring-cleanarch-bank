package io.github.eduardoafinacio.infrastructure.mapper;

import io.github.eduardoafinacio.core.domain.Wallet;
import io.github.eduardoafinacio.infrastructure.entity.TransactionPinEntity;
import io.github.eduardoafinacio.infrastructure.entity.UserEntity;
import io.github.eduardoafinacio.infrastructure.entity.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {
    public WalletEntity toWalletEntity(Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPinEntity){
        return new WalletEntity(
                wallet.getBalance(),
                userEntity,
                transactionPinEntity,
                wallet.getCreatedAt(),
                wallet.getUpdatedAt()
        );
    }
}
