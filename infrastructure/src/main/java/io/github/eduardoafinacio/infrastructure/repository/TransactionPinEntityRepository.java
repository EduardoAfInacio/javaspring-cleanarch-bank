package io.github.eduardoafinacio.infrastructure.repository;

import io.github.eduardoafinacio.infrastructure.entity.TransactionPinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionPinEntityRepository extends JpaRepository<TransactionPinEntity, Long> {
}
