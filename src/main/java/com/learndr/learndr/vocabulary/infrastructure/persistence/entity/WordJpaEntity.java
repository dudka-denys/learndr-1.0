package com.learndr.learndr.vocabulary.infrastructure.persistence.entity;

import jakarta.persistence.*;


import java.time.Instant;

import org.hibernate.annotations.DynamicInsert;

@DynamicInsert
@Entity
@Table(name = "words")
public class WordJpaEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_word")
  private Long idWord;

  @Column(name = "word", nullable = false)
  private String word;

  @Column(name = "meaning", nullable = false)
  private String meaning;

  @Column(name = "context")
  private String context;

  @Column(name = "next_review_at")
  private Instant nextReviewAt;

  @Column(name = "repetition_count")
  private Integer repetitionCount;

  @Column(name = "learn_progress_percentage", nullable = false)
  private Integer learnProgressPercentage = 0;

  @Column(name = "is_learned", nullable = false)
  private boolean isLearned = false;

  @Column(name = "created_at", updatable = false, insertable = false)
  private Instant createdAt;

  @Column(name = "review_lapse_count", nullable = false)
  private Integer reviewLapseCount;

  @Column(name = "fk_user_id", nullable = false)
  // TODO: remove stub (= 1)
  private Long fkUserId = 1L;

  protected WordJpaEntity() {
  }

  public WordJpaEntity(String word, String meaning, String context) {
    this.word = word;
    this.meaning = meaning;
    this.context = context;
  }

  public WordJpaEntity(Long idWord, String word, String meaning, String context) {
    this.idWord = idWord;
    this.word = word;
    this.meaning = meaning;
    this.context = context;
  }

  public WordJpaEntity(Long idWord, String word, String meaning, String context, int learnProgressPercentage) {
    this.idWord = idWord;
    this.word = word;
    this.meaning = meaning;
    this.context = context;
    this.learnProgressPercentage = learnProgressPercentage;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public String getMeaning() {
    return meaning;
  }

  public void setMeaning(String meaning) {
    this.meaning = meaning;
  }

  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }

  public int getLearnProgressPercentage() {
    return learnProgressPercentage != null ? learnProgressPercentage : 0;
  }

  public Long getId() {
    return idWord;
  }

  public boolean getIsLearned() {
    return isLearned;
  }

  public void setIsLearned(boolean isLearned) {
    this.isLearned = isLearned;
    if (isLearned)
      learnProgressPercentage = 100;
    else
      learnProgressPercentage = 0;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }
}
