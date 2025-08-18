package io.github.eduardoafinacio.infrastructure.controller;

import io.github.eduardoafinacio.core.exception.EmailException;
import io.github.eduardoafinacio.core.exception.InternalServerErrorException;
import io.github.eduardoafinacio.core.exception.TaxNumberException;
import io.github.eduardoafinacio.core.exception.TransactionPinException;
import io.github.eduardoafinacio.infrastructure.dto.request.CreateUserRequest;
import io.github.eduardoafinacio.infrastructure.dto.response.BaseResponse;
import io.github.eduardoafinacio.infrastructure.mapper.UserMapper;
import io.github.eduardoafinacio.usecase.CreateUserUseCase;
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

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping("/createUser")
    public BaseResponse<String> createUser(@RequestBody CreateUserRequest request) throws TaxNumberException, EmailException, InternalServerErrorException, TransactionPinException {
        log.info("Starting to create user::UserController");
        createUserUseCase.create(userMapper.toUser(request), request.pin());
        log.info("User created successfully::UserController");
        return BaseResponse.<String>builder().success(true).message("User created").build();
    }
}
