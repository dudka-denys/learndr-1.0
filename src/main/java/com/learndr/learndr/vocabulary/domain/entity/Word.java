package com.learndr.learndr.vocabulary.domain.entity;

import java.time.Instant;

public class Word {
  private final WordId id;
  private String word;
  private String meaning;
  private String context;
  private int learnProgressPercentage;
  private boolean isLearned;
  private Instant createdAt;

  public Word(String word, String meaning, String context) {
    this.id = null;
    this.word = word;
    this.meaning = meaning;
    this.context = context;
    this.learnProgressPercentage = 0;
    this.isLearned = false;
    this.createdAt = Instant.now();
  }

  public Word(
      WordId id,
      String word,
      String meaning,
      String context,
      boolean isLearned) {
    this.id = id;
    this.word = word;
    this.meaning = meaning;
    this.context = context;
    this.learnProgressPercentage = isLearned ? 100 : 0;
    this.isLearned = isLearned;
  }

  public Word(
      WordId id,
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

  public void changeWordValue(String value) {
    this.word = value;
  }

  public void changeMeaning(String value) {
    this.meaning = value;
  }

  public void changeContext(String value) {
    this.context = value;
  }

  public void changeIsLearned(boolean value) {
    this.isLearned = value;
    if (value)
      learnProgressPercentage = 100;
    else
      learnProgressPercentage = 0;
  }

  public WordId getId() {
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

  public boolean getIsLearned() {
    return isLearned;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }
}