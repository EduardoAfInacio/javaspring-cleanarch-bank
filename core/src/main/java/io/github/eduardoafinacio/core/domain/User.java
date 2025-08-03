package io.github.eduardoafinacio.core.domain;

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
}
