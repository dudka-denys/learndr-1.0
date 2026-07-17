package com.learndr.learndr.auth.domain.entity;

public class User {
  public UserId id;
  public String userName;
  public String email;
  public String passwordHash;
  public Locale preferredLocale;
  public RoleId roleId;

  public User(
      String userName,
      String email,
      String passwordHash,
      Locale preferredLocale,
      RoleId roleId) {
    this.userName = userName;
    this.email = email;
    this.passwordHash = passwordHash;
    this.preferredLocale = preferredLocale;
    this.roleId = roleId;
  }
}
