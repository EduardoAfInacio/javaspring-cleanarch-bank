package io.github.eduardoafinacio.infrastructure.mapper;

import io.github.eduardoafinacio.core.domain.TaxNumber;
import io.github.eduardoafinacio.core.domain.User;
import io.github.eduardoafinacio.core.exception.TaxNumberException;
import io.github.eduardoafinacio.infrastructure.dto.request.CreateUserRequest;
import io.github.eduardoafinacio.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity toUserEntity(User user){
        return new UserEntity(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getTaxNumber().getValue(),
                user.getFullName(),
                user.getType(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    public User toUser(CreateUserRequest request) throws TaxNumberException {
        return new User(
                request.email(),
                request.password(),
                request.fullname(),
                new TaxNumber(request.taxNumber()),
                request.type()
        );
    }
}
