package io.github.eduardoafinacio.infrastructure.service;

import io.github.eduardoafinacio.core.domain.User;
import io.github.eduardoafinacio.core.domain.Wallet;
import io.github.eduardoafinacio.gateway.CreateUserGateway;
import io.github.eduardoafinacio.infrastructure.mapper.TransactionPinMapper;
import io.github.eduardoafinacio.infrastructure.mapper.UserMapper;
import io.github.eduardoafinacio.infrastructure.mapper.WalletMapper;
import io.github.eduardoafinacio.infrastructure.repository.TransactionPinEntityRepository;
import io.github.eduardoafinacio.infrastructure.repository.UserEntityRepository;
import io.github.eduardoafinacio.infrastructure.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;

import static io.github.eduardoafinacio.infrastructure.Utils.Utilities.log;

@Service
public class CreateUserGatewayImpl implements CreateUserGateway {
    private UserEntityRepository userEntityRepository;
    private UserMapper userMapper;
    private TransactionPinEntityRepository transactionPinEntityRepository;
    private TransactionPinMapper transactionPinMapper;
    private WalletEntityRepository walletEntityRepository;
    private WalletMapper walletMapper;

    CreateUserGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper, TransactionPinEntityRepository transactionPinEntityRepository, TransactionPinMapper transactionPinMapper, WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
        this.transactionPinEntityRepository = transactionPinEntityRepository;
        this.transactionPinMapper = transactionPinMapper;
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    public Boolean create(User user, Wallet wallet) {
        try{
            log.info("Starting user creation::CreateUserGatewayImpl");
            var userEntitySaved = userEntityRepository.save(userMapper.toUserEntity(user));
            var transactionPinEntitySaved = transactionPinEntityRepository.save(transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin()));
            walletEntityRepository.save(walletMapper.toWalletEntity(wallet, userEntitySaved, transactionPinEntitySaved));
            log.info("User created successfully::CreateUserGatewayImpl");
            return true;
        }catch (Exception e){
            log.error("There was an error creating the user::CreateUserGatewayImpl");
            return false;
        }
    }
}
