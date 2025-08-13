package io.github.eduardoafinacio.gateway;

import io.github.eduardoafinacio.core.domain.Transaction;

public interface UserNotificationGateway {
    Boolean notificate(Transaction transaction, String email);
}
