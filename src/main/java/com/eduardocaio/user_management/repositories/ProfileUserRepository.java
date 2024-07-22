package com.eduardocaio.user_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardocaio.user_management.entities.ProfileUserEntity;

public interface ProfileUserRepository extends JpaRepository<ProfileUserEntity, Long>{

}
