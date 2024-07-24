package com.eduardocaio.user_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardocaio.user_management.entities.VerificationUserEntity;

public interface VerificationUserRepository extends JpaRepository<VerificationUserEntity, Long>{

}