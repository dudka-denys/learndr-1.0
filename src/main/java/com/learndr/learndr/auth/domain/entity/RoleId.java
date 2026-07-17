package com.learndr.learndr.auth.domain.entity;

public final class RoleId {
  private final long value;

  public RoleId(long value) {
    if (value > 0)
      this.value = value;
    else throw new IllegalArgumentException("Role id must me bigger than 0");
  }

  public long value() {
    return value;
  }

}
