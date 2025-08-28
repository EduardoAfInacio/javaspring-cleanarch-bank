package io.github.eduardoafinacio.infrastructure.controller;

import io.github.eduardoafinacio.core.exception.EmailException;
import io.github.eduardoafinacio.core.exception.InternalServerErrorException;
import io.github.eduardoafinacio.core.exception.TaxNumberException;
import io.github.eduardoafinacio.core.exception.TransactionPinException;
import io.github.eduardoafinacio.infrastructure.dto.request.CreateUserRequest;
import io.github.eduardoafinacio.infrastructure.dto.response.BaseResponse;
import io.github.eduardoafinacio.infrastructure.mapper.UserMapper;
import io.github.eduardoafinacio.usecase.CreateUserUseCase;
import io.github.eduardoafinacio.usecase.EmailAvailableUseCase;
import io.github.eduardoafinacio.usecase.TaxNumberAvailableUseCase;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.github.eduardoafinacio.infrastructure.Utils.Utilities.log;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private CreateUserUseCase createUserUseCase;
    private UserMapper userMapper;
    private TaxNumberAvailableUseCase taxNumberAvailableUseCase;
    private EmailAvailableUseCase emailAvailableUseCase;

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper, TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
    }

    @PostMapping("/createUser")
    public BaseResponse<String> createUser(@Valid @RequestBody CreateUserRequest request) throws TaxNumberException, EmailException, InternalServerErrorException, TransactionPinException {
        log.info("Starting to validate tax number and email::UserController");
        taxNumberAvailableUseCase.taxNumberAvailable(request.taxNumber());
        emailAvailableUseCase.emailAvailable(request.email());
        log.info("TaxNumber and Email validated successfully::UserController");
        log.info("Starting to create user::UserController");
        createUserUseCase.create(userMapper.toUser(request), request.pin());
        log.info("User created successfully::UserController");
        return BaseResponse.<String>builder().success(true).message("User created").build();
    }
}
