package io.github.eduardoafinacio.infrastructure.controller;

import io.github.eduardoafinacio.infrastructure.dto.request.CreateUserRequest;
import io.github.eduardoafinacio.infrastructure.dto.response.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/users")
public class UserController {
    public BaseResponse<String> createUser(@RequestBody CreateUserRequest request){
        return BaseResponse.<String>builder().success(true).message("User created").build();
    }
}
