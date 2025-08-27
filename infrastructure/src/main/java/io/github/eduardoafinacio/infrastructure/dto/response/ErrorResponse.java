package io.github.eduardoafinacio.infrastructure.dto.response;

import java.util.List;

public record ErrorResponse(String message, String code, List<ValidationError> validations) {
}
