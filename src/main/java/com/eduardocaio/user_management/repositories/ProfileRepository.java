package com.eduardocaio.user_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardocaio.user_management.entities.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long>{

}
