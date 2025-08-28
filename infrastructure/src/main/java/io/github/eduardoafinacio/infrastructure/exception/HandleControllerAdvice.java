package io.github.eduardoafinacio.infrastructure.exception;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.github.eduardoafinacio.core.exception.enums.ErrorCodeEnum;
import io.github.eduardoafinacio.infrastructure.dto.response.BaseResponse;
import io.github.eduardoafinacio.infrastructure.dto.response.ErrorResponse;
import io.github.eduardoafinacio.infrastructure.dto.response.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class HandleControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        var error = new ErrorResponse(
                ErrorCodeEnum.IR0001.getMessage(),
                ErrorCodeEnum.IR0001.getCode(),
                exception.getBindingResult().getFieldErrors().stream()
                        .map(fieldError -> new ValidationError(fieldError.getField(), fieldError.getDefaultMessage()))
                        .collect(Collectors.toList())
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(BaseResponse.<ValidationError>builder().success(false).error(error).build());
    }
}
