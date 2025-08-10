package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.domain.Transaction;

public interface UserNotificationUseCase {
    Boolean notificate(Transaction transaction, String email);
}
