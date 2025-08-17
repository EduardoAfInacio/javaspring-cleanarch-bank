package io.github.eduardoafinacio.infrastructure.dto.request;

import io.github.eduardoafinacio.core.domain.enums.UserTypeEnum;

public record CreateUserRequest(String email, String password, String taxNumber, String fullname, UserTypeEnum type, String pin) {
}
