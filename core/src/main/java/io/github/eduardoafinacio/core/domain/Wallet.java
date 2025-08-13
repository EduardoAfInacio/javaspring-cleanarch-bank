package io.github.eduardoafinacio.core.domain;

import io.github.eduardoafinacio.core.domain.enums.UserTypeEnum;
import io.github.eduardoafinacio.core.exception.TransferException;
import io.github.eduardoafinacio.core.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Wallet {
    private Long id;
    private TransactionPin transactionPin;
    private BigDecimal balance;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Wallet(Long id, TransactionPin transactionPin, BigDecimal balance, User user, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.transactionPin = transactionPin;
        this.balance = balance;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Wallet(TransactionPin transactionPin, BigDecimal balance, User user) {
        this.transactionPin = transactionPin;
        this.balance = balance;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public Wallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void receiveValue(BigDecimal value) {
        this.balance = this.balance.add(value);
    }

    public void transferValue(BigDecimal value) throws TransferException{
        if(this.user.getType() == UserTypeEnum.SHOPKEEPER) {
            throw new TransferException(ErrorCodeEnum.TR0001.getMessage(), ErrorCodeEnum.TR0001.getCode());
        }

        if(this.balance.compareTo(value) < 0) {
            throw new TransferException(ErrorCodeEnum.TR0002.getMessage(), ErrorCodeEnum.TR0002.getCode());
        }

        this.balance = this.balance.subtract(value);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TransactionPin getTransactionPin() {
        return transactionPin;
    }

    public void setTransactionPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(getId(), wallet.getId()) && Objects.equals(getTransactionPin(), wallet.getTransactionPin()) && Objects.equals(getBalance(), wallet.getBalance()) && Objects.equals(getUser(), wallet.getUser()) && Objects.equals(getCreatedAt(), wallet.getCreatedAt()) && Objects.equals(getUpdatedAt(), wallet.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTransactionPin(), getBalance(), getUser(), getCreatedAt(), getUpdatedAt());
    }
}
