package com.learndr.learndr.auth.infrastructure.repository.spec;

import org.springframework.data.jpa.domain.Specification;

import com.learndr.learndr.auth.infrastructure.persistance.entity.UserJpaEntity;

public final class UserSpecs {
  public static Specification<UserJpaEntity> emailContains(String q) {
    return (root, query, cb) -> {
      if (q.isBlank() || q == null)
        return cb.conjunction();
      String like = q.trim().toLowerCase();
      return cb.like(cb.lower(root.get("email")), like);
    };
  }
}
