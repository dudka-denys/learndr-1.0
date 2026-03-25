package com.learndr.learndr.vocabulary.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.time.Instant;

import org.hibernate.annotations.DynamicInsert;

@DynamicInsert
@Entity
@Table(name = "words", schema = "schema_vocabulary")
public class WordJpaEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_word")
  private Long id_word;

  @Column(nullable = false)
  private String word;

  @Column(nullable = false)
  private String meaning;
  
  @Column
  private String context;
  
  @Column
  private Instant next_review_at;
  
  @Column
  private Integer repetition_count;
  
  @Column(nullable = false)
  private Integer learn_progress_percentage = 0;
  
  @Column(nullable = false)
  private Boolean is_learned = false;
  
  @Column(updatable = false, insertable = false)
  private Instant created_at;
  
  @Column(nullable = false)
  private Integer review_lapse_count;

  protected WordJpaEntity() {
  }

  public WordJpaEntity(String word, String meaning, String context) {
    this.word = word;
    this.meaning = meaning;
    this.context = context;
  }

  public WordJpaEntity(Long id_word, String word, String meaning, String context) {
    this.id_word = id_word;
    this.word = word;
    this.meaning = meaning;
    this.context = context;
  }

  public WordJpaEntity(Long id_word, String word, String meaning, String context, int learn_progress_percentage) {
    this.id_word = id_word;
    this.word = word;
    this.meaning = meaning;
    this.context = context;
    this.learn_progress_percentage = learn_progress_percentage;
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
    return learn_progress_percentage != null ? learn_progress_percentage : 0;
  }

  public Long getId() {
    return id_word;
  }

  public boolean getIsLearned() {
    return Boolean.TRUE.equals(is_learned);
  }

  public void setIsLearned(boolean isLearned) {
    this.is_learned = isLearned;
  }

  public Instant getCreatedAt() {
    return created_at;
  }
}
