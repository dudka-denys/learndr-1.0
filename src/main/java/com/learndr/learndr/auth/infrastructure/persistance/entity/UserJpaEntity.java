package com.learndr.learndr.auth.infrastructure.persistance.entity;

import java.time.Instant;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserJpaEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id_user;

  @Column(nullable = false)
  private String display_name;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String preferred_locale;

  @Column(nullable = false)
  private Long fk_role_id;

  @Column(nullable = false)
  private String password_hash;

  @Column
  private Instant email_verified_at;

  @Column
  private Instant last_login_at;

  protected UserJpaEntity() {
  }
}
