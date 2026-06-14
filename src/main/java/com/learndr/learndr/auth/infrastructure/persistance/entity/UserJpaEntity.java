package com.learndr.learndr.auth.infrastructure.persistance.entity;

import java.time.Instant;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserJpaEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_user", nullable = false)
  private Long idUser;

  @Column(name = "user_name", nullable = false)
  private String userName;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "preferred_locale", nullable = false)
  private String preferredLocale;

  @Column(name = "fk_role_id", nullable = false)
  private Long fkRoleId = 1L;

  @Column(name = "password_hash", nullable = false)
  private String passwordHash;

  @Column(name = "email_verified_at")
  private Instant emailVerifiedAt;

  @Column(name = "last_login_at")
  private Instant lastLoginAt;

  protected UserJpaEntity() {
  }

  public UserJpaEntity(
      String userName,
      String email,
      String preferredLocale,
      String passwordHash
  ) {
    this.userName = userName;
    this.email = email;
    this.preferredLocale = preferredLocale;
    this.passwordHash = passwordHash;
  }

  public UserJpaEntity(
      String userName,
      String email,
      String preferredLocale,
      String passwordHash,
      Long fkRoleId
  ) {
    this(userName, email, preferredLocale, passwordHash);
    this.fkRoleId = fkRoleId;
  }

  public Long getIdUser() {
    return idUser;
  }

  public String getUserName() {
    return userName;
  }

  public String getEmail() {
    return email;
  }

  public String getPreferredLocale() {
    return preferredLocale;
  }

  public Long getFkRoleId() {
    return fkRoleId;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public Instant getEmailVerifiedAt() {
    return emailVerifiedAt;
  }

  public Instant getLastLoginAt() {
    return lastLoginAt;
  }
}
