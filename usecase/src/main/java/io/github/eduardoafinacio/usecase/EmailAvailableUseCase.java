package io.github.eduardoafinacio.usecase;

import io.github.eduardoafinacio.core.exception.EmailException;

public interface EmailAvailableUseCase {
    Boolean emailAvailable(String email) throws EmailException;
}
