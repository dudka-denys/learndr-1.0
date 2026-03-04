package com.learndr.learndr.vocabulary.application.dto.result;

import java.time.Instant;

import jakarta.persistence.Id;

public record WordOutput(
    Long id,
    String word,
    String meaning,
    String context,
    int learnProgressPercentage,
    boolean isLearned,
    Instant createdAt) {
  public WordOutput(
      Long id,
      String word,
      String meaning,
      String context,
      int learnProgressPercentage,
      boolean isLearned,
      Instant createdAt) {
    this.id = id;
    this.word = word;
    this.meaning = meaning;
    this.context = context;
    this.learnProgressPercentage = learnProgressPercentage;
    this.isLearned = isLearned;
    this.createdAt = createdAt;
  }
  public Long getId() {
    return id;
  }
  public String getWord() {
    return word;
  }
  public String getMeaning() {
    return meaning;
  }
  public String getContext() {
    return context;
  }
  public int getLearnProgressPercentage() {
    return learnProgressPercentage;
  }
  public boolean isLearned() {
    return isLearned;
  }
  public Instant getCreatedAt() {
    return createdAt;
  }
}
