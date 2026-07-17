package com.learndr.learndr.auth.infrastructure.persistance.mapper;

import com.learndr.learndr.auth.domain.entity.User;
import com.learndr.learndr.auth.infrastructure.persistance.entity.UserJpaEntity;

public class UserJpaMapper {
  public static UserJpaEntity fromDomain(User user) {
    return new UserJpaEntity(
        user.userName,
        user.email,
        user.preferredLocale.toString(),
        user.passwordHash,
        user.roleId.value());
  }
}
