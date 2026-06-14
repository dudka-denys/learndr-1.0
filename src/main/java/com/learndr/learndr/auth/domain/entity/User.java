package com.learndr.learndr.auth.domain.entity;

public class User {
  public UserId id;
  public String userName;
  public String mail;
  public String passwordHash;
  public Locale preferredLocale;
  public int fkRoleId;

  public User(
      String userName,
      String mail,
      String passwordHash,
      Locale preferredLocale,
      int fkRoleId) {
    this.userName = userName;
    this.mail = mail;
    this.passwordHash = passwordHash;
    this.preferredLocale = preferredLocale;
    this.fkRoleId = fkRoleId;
  }
}
