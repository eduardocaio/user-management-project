package com.eduardocaio.user_management.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardocaio.user_management.entities.VerificationUserEntity;

public interface VerificationUserRepository extends JpaRepository<VerificationUserEntity, Long>{

    public Optional<VerificationUserEntity> findByUuid(UUID uuid);
}
