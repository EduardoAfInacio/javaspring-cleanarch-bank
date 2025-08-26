package io.github.eduardoafinacio.infrastructure.mapper;

import io.github.eduardoafinacio.core.domain.Transaction;
import io.github.eduardoafinacio.core.domain.enums.TransactionStatusEnum;
import io.github.eduardoafinacio.core.exception.TaxNumberException;
import io.github.eduardoafinacio.infrastructure.entity.TransactionEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    private WalletMapper walletMapper;
    private UserMapper userMapper;
    private TransactionPinMapper transactionPinMapper;

    public TransactionMapper(WalletMapper walletMapper, UserMapper userMapper, TransactionPinMapper transactionPinMapper) {
        this.walletMapper = walletMapper;
    }

    public TransactionEntity toTransactionEntity(Transaction transaction) {
        return new TransactionEntity(
                transaction.getId(),
                walletMapper.toWalletEntity(transaction.getFromWallet()),
                walletMapper.toWalletEntity(transaction.getToWallet()),
                transaction.getValue(),
                transaction.getStatus(),
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }

    public TransactionEntity toTransactionEntityForCreation(Transaction transaction) {
        return new TransactionEntity(
                walletMapper.toWalletEntityUpdate(transaction.getFromWallet()),
                walletMapper.toWalletEntityUpdate(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatusEnum.CREATED,
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }

    public TransactionEntity toTransactionSuccessEntity(Transaction transaction) {
        return new TransactionEntity(
                transaction.getId(),
                walletMapper.toWalletEntityUpdate(transaction.getFromWallet()),
                walletMapper.toWalletEntityUpdate(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatusEnum.SUCCESS,
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }

    public TransactionEntity toTransactionCanceledEntity(Transaction transaction) {
        return new TransactionEntity(
                transaction.getId(),
                walletMapper.toWalletEntity(transaction.getFromWallet()),
                walletMapper.toWalletEntity(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatusEnum.CANCELED,
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }

    public Transaction toTransaction(TransactionEntity transactionEntity) throws TaxNumberException {
        return new Transaction(
                transactionEntity.getId(),
                walletMapper.toWallet(transactionEntity.getFromWallet()),
                walletMapper.toWallet(transactionEntity.getToWallet()),
                transactionEntity.getTransactionValue(),
                transactionEntity.getStatus(),
                transactionEntity.getCreatedAt(),
                transactionEntity.getUpdatedAt()
        );
    }


}
