package io.github.eduardoafinacio.infrastructure.service;

import io.github.eduardoafinacio.core.domain.Transaction;
import io.github.eduardoafinacio.gateway.UserNotificationGateway;
import org.springframework.stereotype.Service;

@Service
public class UserNotificationGatewayImpl implements UserNotificationGateway {
    @Override
    public Boolean notificate(Transaction transaction, String email) {
        return true;
    }
}
