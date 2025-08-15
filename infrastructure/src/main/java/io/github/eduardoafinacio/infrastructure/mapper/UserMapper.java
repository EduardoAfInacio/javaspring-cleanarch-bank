package io.github.eduardoafinacio.infrastructure.mapper;

import io.github.eduardoafinacio.core.domain.User;
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
}
