package io.github.eduardoafinacio.infrastructure.dto.request;

import io.github.eduardoafinacio.core.domain.enums.UserTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserRequest(@NotBlank String email, @NotBlank String password, @NotBlank String taxNumber, @NotBlank String fullname, @NotNull UserTypeEnum type, @NotBlank String pin) {
}
