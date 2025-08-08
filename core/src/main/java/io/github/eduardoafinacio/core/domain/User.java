package io.github.eduardoafinacio.core.domain;

import io.github.eduardoafinacio.core.domain.enums.UserTypeEnum;

import java.util.Objects;
import java.util.UUID;
import java.time.LocalDateTime;

public class User {
    private UUID id;
    private String email;
    private String password;
    private String fullName;
    private TaxNumber taxNumber;
    private UserTypeEnum type;
    private TransactionPin transactionPin;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(UUID id, String email, String password, String fullName, TaxNumber taxNumber, UserTypeEnum type, TransactionPin transactionPin, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.taxNumber = taxNumber;
        this.type = type;
        this.transactionPin = transactionPin;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User(String email, String password, String fullName, TaxNumber taxNumber, UserTypeEnum type, TransactionPin transactionPin) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.taxNumber = taxNumber;
        this.type = type;
        this.transactionPin = transactionPin;
        this.createdAt = LocalDateTime.now();
    }

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public TaxNumber getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(TaxNumber taxNumber) {
        this.taxNumber = taxNumber;
    }

    public UserTypeEnum getType() {
        return type;
    }

    public void setType(UserTypeEnum type) {
        this.type = type;
    }

    public TransactionPin getTransactionPin() {
        return transactionPin;
    }

    public void setTransactionPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getFullName(), user.getFullName()) && Objects.equals(getTaxNumber(), user.getTaxNumber()) && getType() == user.getType() && Objects.equals(getTransactionPin(), user.getTransactionPin()) && Objects.equals(getCreatedAt(), user.getCreatedAt()) && Objects.equals(getUpdatedAt(), user.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getPassword(), getFullName(), getTaxNumber(), getType(), getTransactionPin(), getCreatedAt(), getUpdatedAt());
    }
}
