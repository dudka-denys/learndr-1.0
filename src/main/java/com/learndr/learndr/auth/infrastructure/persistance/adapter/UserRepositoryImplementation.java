package com.learndr.learndr.auth.infrastructure.persistance.adapter;

import org.springframework.stereotype.Repository;

import com.learndr.learndr.auth.domain.entity.User;
import com.learndr.learndr.auth.domain.repository.UserRepository;
import com.learndr.learndr.auth.infrastructure.repository.SpringDataUserRepository;

@Repository
public class UserRepositoryImplementation implements UserRepository {
  SpringDataUserRepository jpa;
  public UserRepositoryImplementation(SpringDataUserRepository jpa){
    this.jpa = jpa;
  }
  @Override
  public void save(User user) {
    
  }
}
