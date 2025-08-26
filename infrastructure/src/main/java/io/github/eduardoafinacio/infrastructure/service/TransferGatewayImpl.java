package io.github.eduardoafinacio.infrastructure.service;

import io.github.eduardoafinacio.core.domain.Transaction;
import io.github.eduardoafinacio.gateway.TransferGateway;
import io.github.eduardoafinacio.infrastructure.mapper.TransactionMapper;
import io.github.eduardoafinacio.infrastructure.mapper.WalletMapper;
import io.github.eduardoafinacio.infrastructure.repository.TransactionEntityRepository;
import io.github.eduardoafinacio.infrastructure.repository.WalletEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TransferGatewayImpl implements TransferGateway {
    private WalletEntityRepository walletEntityRepository;
    private TransactionEntityRepository transactionEntityRepository;
    private WalletMapper walletMapper;
    private TransactionMapper transactionMapper;

    public TransferGatewayImpl(WalletEntityRepository walletEntityRepository, TransactionEntityRepository transactionEntityRepository, WalletMapper walletMapper, TransactionMapper transactionMapper) {
        this.walletEntityRepository = walletEntityRepository;
        this.transactionEntityRepository = transactionEntityRepository;
        this.walletMapper = walletMapper;
        this.transactionMapper = transactionMapper;
    }
    @Override
    @Transactional
    public Boolean transfer(Transaction transaction) {
        try{
            walletEntityRepository.save(walletMapper.toWalletEntityUpdate(transaction.getFromWallet()));
            walletEntityRepository.save(walletMapper.toWalletEntityUpdate(transaction.getToWallet()));

            transactionEntityRepository.save(transactionMapper.toTransactionSuccessEntity(transaction));
            return true;
        }catch (Exception e){
            transactionEntityRepository.save(transactionMapper.toTransactionCanceledEntity(transaction));
            return false;
        }
    }
}
