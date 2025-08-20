package io.github.eduardoafinacio.infrastructure.repository;

import io.github.eduardoafinacio.infrastructure.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long> {
    WalletEntity findByUserEntityTaxNumber(String taxNumber);
}
