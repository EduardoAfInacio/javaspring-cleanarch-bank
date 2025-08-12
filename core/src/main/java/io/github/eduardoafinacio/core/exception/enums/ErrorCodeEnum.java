package io.github.eduardoafinacio.core.exception.enums;

public enum ErrorCodeEnum {
    ON0001("Tax number is invalid", "ON-0001"),
    ON0002("Tax number is unavailable", "ON-0002"),
    ON0003("Email is unavailable", "ON-0003"),
    ON0004("Error when creating user", "ON-0004"),
    TR0001("Transaction cannot be made by a shopkeeper", "TR-0001"),
    TR0002("Unavailable balance", "TR-0002"),
    TR0003("Error when transferring", "TR-0003"),
    TRP0001("Transaction PIN is invalid", "TRP-0001"),
    WA0001("Wallet not found", "WA-0001"),
    ;

    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
