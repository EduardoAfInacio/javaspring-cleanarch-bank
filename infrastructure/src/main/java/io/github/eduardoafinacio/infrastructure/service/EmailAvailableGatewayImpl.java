package io.github.eduardoafinacio.infrastructure.service;

import io.github.eduardoafinacio.gateway.EmailAvailableGateway;
import io.github.eduardoafinacio.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import static io.github.eduardoafinacio.infrastructure.Utils.Utilities.log;

@Service
public class EmailAvailableGatewayImpl implements EmailAvailableGateway {
    private UserEntityRepository userEntityRepository;

    public EmailAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }
    @Override
    public Boolean emailAvailable(String email) {
        log.info("Starting to check if email is available::EmailAvailableGatewayImpl");
        return !userEntityRepository.existsByEmail(email);
    }
}
