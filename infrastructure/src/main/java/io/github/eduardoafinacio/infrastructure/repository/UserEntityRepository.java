package io.github.eduardoafinacio.infrastructure.repository;

import io.github.eduardoafinacio.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {
}
