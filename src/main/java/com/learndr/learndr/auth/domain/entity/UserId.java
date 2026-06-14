package com.learndr.learndr.auth.domain.entity;

public final class UserId {
  public final long value;

  public UserId(long value) {
    if (value < 1)
      throw new IllegalArgumentException("User id must be bigger than 0");
    else
      this.value = value;
  }

  public long value() {
    return value;
  }
}
