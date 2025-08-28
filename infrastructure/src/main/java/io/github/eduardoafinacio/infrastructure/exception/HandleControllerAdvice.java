package io.github.eduardoafinacio.infrastructure.exception;

import io.github.eduardoafinacio.core.exception.*;
import io.github.eduardoafinacio.core.exception.enums.ErrorCodeEnum;
import io.github.eduardoafinacio.infrastructure.dto.response.BaseResponse;
import io.github.eduardoafinacio.infrastructure.dto.response.ErrorResponse;
import io.github.eduardoafinacio.infrastructure.dto.response.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.stream.Collectors;

@ControllerAdvice
public class HandleControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<ValidationError>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
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

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<BaseResponse<String>> handleAuthenticationException(AuthenticationException exception){
        var error = new ErrorResponse(
                exception.getMessage(),
                exception.getCode(),
                null
        );

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(BaseResponse.<String>builder().success(false).error(error).build());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BaseResponse<String>> handleBadRequestException(BadRequestException exception){
        var error = new ErrorResponse(
                exception.getMessage(),
                exception.getCode(),
                null
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(BaseResponse.<String>builder().success(false).error(error).build());
    }

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<BaseResponse<String>> handleEmailException(EmailException exception){
        var error = new ErrorResponse(
                exception.getMessage(),
                exception.getCode(),
                null
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(BaseResponse.<String>builder().success(false).error(error).build());
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<BaseResponse<String>> handleInternalServerErrorException(InternalServerErrorException exception){
        var error = new ErrorResponse(
                exception.getMessage(),
                exception.getCode(),
                null
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(BaseResponse.<String>builder().success(false).error(error).build());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BaseResponse<String>> handleNotFoundException(NotFoundException exception){
        var error = new ErrorResponse(
                exception.getMessage(),
                exception.getCode(),
                null
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(BaseResponse.<String>builder().success(false).error(error).build());
    }

    @ExceptionHandler(NotificationException.class)
    public ResponseEntity<BaseResponse<String>> handleNotificationException(NotificationException exception){
        var error = new ErrorResponse(
                exception.getMessage(),
                exception.getCode(),
                null
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(BaseResponse.<String>builder().success(false).error(error).build());
    }

    @ExceptionHandler(TransactionPinException.class)
    public ResponseEntity<BaseResponse<String>> handleTransactionPinException(TransactionPinException exception){
        var error = new ErrorResponse(
                exception.getMessage(),
                exception.getCode(),
                null
        );

        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(BaseResponse.<String>builder().success(false).error(error).build());
    }

    @ExceptionHandler(TaxNumberException.class)
    public ResponseEntity<BaseResponse<String>> handleTaxNumberException(TaxNumberException exception){
        var error = new ErrorResponse(
                exception.getMessage(),
                exception.getCode(),
                null
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(BaseResponse.<String>builder().success(false).error(error).build());
    }

    @ExceptionHandler(TransferException.class)
    public ResponseEntity<BaseResponse<String>> handleTransferException(TransferException exception){
        var error = new ErrorResponse(
                exception.getMessage(),
                exception.getCode(),
                null
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(BaseResponse.<String>builder().success(false).error(error).build());
    }
}
