package io.github.eduardoafinacio.core.domain;

import io.github.eduardoafinacio.core.exception.TransactionPinException;
import io.github.eduardoafinacio.core.exception.enums.ErrorCodeEnum;

import java.time.LocalDateTime;

public class TransactionPin {
    private Long id;
    private User user;
    private String pin;
    private Integer attempt;
    private Boolean blocked;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TransactionPin(Long id, User user, String pin, Integer attempt, Boolean blocked, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.pin = pin;
        this.user = user;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TransactionPin(User user,String pin) throws TransactionPinException{
        this.user = user;
        setPin(pin);
        this.attempt = 3;
        this.blocked = false;
        this.createdAt = LocalDateTime.now();
    }

    public TransactionPin() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) throws TransactionPinException{
        pinIsValid(pin);
        this.pin = pin;
    }

    private void pinIsValid(String pin) throws TransactionPinException{
        if(pin.length() != 8){
            throw new TransactionPinException(ErrorCodeEnum.TRP0001.getMessage(), ErrorCodeEnum.TRP0001.getCode());
        }
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
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
}

