package io.github.eduardoafinacio.infrastructure.repository;

import io.github.eduardoafinacio.infrastructure.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionEntityRepository extends JpaRepository<TransactionEntity, Long> {
}
