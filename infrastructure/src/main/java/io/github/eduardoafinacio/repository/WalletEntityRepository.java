package io.github.eduardoafinacio.repository;

import io.github.eduardoafinacio.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long> {
}
