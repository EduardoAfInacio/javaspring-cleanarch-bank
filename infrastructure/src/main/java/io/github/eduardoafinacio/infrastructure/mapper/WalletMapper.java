package io.github.eduardoafinacio.infrastructure.mapper;

import io.github.eduardoafinacio.core.domain.Wallet;
import io.github.eduardoafinacio.core.exception.TaxNumberException;
import io.github.eduardoafinacio.infrastructure.entity.TransactionPinEntity;
import io.github.eduardoafinacio.infrastructure.entity.UserEntity;
import io.github.eduardoafinacio.infrastructure.entity.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {
    private UserMapper userMapper;
    private TransactionPinMapper transactionPinMapper;

    public WalletMapper(UserMapper userMapper, TransactionPinMapper transactionPinMapper) {
        this.userMapper = userMapper;
        this.transactionPinMapper = transactionPinMapper;
    }

    public WalletEntity toWalletEntity(Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPinEntity){
        return new WalletEntity(
                wallet.getBalance(),
                userEntity,
                transactionPinEntity,
                wallet.getCreatedAt(),
                wallet.getUpdatedAt()
        );
    }

    public Wallet toWallet(WalletEntity walletEntity) throws TaxNumberException {
        if(walletEntity == null) return null;

        return new Wallet(
                walletEntity.getId(),
                transactionPinMapper.toTransactionPin(walletEntity.getTransactionPinEntity()),
                walletEntity.getBalance(),
                userMapper.toUser(walletEntity.getUserEntity()),
                walletEntity.getCreatedAt(),
                walletEntity.getUpdatedAt()
        );
    }
}
