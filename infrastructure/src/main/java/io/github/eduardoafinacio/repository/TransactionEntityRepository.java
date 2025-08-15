package io.github.eduardoafinacio.repository;

import io.github.eduardoafinacio.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionEntityRepository extends JpaRepository<TransactionEntity, Long> {
}
