package com.eduardocaio.user_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardocaio.user_management.entities.PermissionProfileResourceEntity;

public interface PermissionProfileResourceRepository extends JpaRepository<PermissionProfileResourceEntity, Long>{

}
