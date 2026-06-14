package com.learndr.learndr.auth.domain.repository;

import com.learndr.learndr.auth.domain.entity.User;

public interface UserRepository {
  public void save(User user);
}
