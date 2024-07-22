package com.eduardocaio.user_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardocaio.user_management.entities.ResourceEntity;

public interface ResourceRepository extends JpaRepository<ResourceEntity, Long>{

}
