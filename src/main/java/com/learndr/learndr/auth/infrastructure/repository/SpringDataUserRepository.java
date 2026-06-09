package com.learndr.learndr.auth.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.learndr.learndr.auth.infrastructure.persistance.entity.UserJpaEntity;

public interface SpringDataUserRepository extends JpaRepository<UserJpaEntity, Long>, JpaSpecificationExecutor<UserJpaEntity>{
  
}
