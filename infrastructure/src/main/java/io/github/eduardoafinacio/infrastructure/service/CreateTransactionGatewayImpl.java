package io.github.eduardoafinacio.infrastructure.service;

import io.github.eduardoafinacio.core.domain.Transaction;
import io.github.eduardoafinacio.gateway.CreateTransactionGateway;
import io.github.eduardoafinacio.infrastructure.mapper.TransactionMapper;
import io.github.eduardoafinacio.infrastructure.repository.TransactionEntityRepository;

public class CreateTransactionGatewayImpl implements CreateTransactionGateway {
    private TransactionEntityRepository transactionEntityRepository;
    private TransactionMapper transactionMapper;

    public CreateTransactionGatewayImpl(TransactionEntityRepository transactionEntityRepository, TransactionMapper transactionMapper) {
        this.transactionEntityRepository = transactionEntityRepository;
        this.transactionMapper = transactionMapper;
    }
    @Override
    public Transaction create(Transaction transaction) {
        try{
            var transactionEntitySaved = transactionEntityRepository.save(transactionMapper.toTransactionEntityForCreation(transaction));
            return transactionMapper.toTransaction(transactionEntitySaved);
        }catch (Exception e){
            return null;
        }
    }
}
