package com.eduardocaio.user_management.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardocaio.user_management.entities.UserEntity;
import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity, Long>{

    Optional<UserEntity> findByLogin (String login);

}
