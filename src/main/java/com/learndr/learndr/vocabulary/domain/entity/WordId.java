package com.learndr.learndr.vocabulary.domain.entity;

public final class WordId {
  private final long value;

  public WordId(long value) {
    if (value <= 0) {
      throw new IllegalArgumentException("WordId value must be positive");
    }
    this.value = value;
  }


  public Long value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof WordId)) return false;
    WordId other = (WordId) o;
    return value == other.value;
  }

  @Override
  public int hashCode() {
    return Long.hashCode(value);
  }

  @Override
  public String toString() {
    return "WordId{" + "value=" + value + '}';
  }
}
