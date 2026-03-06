package com.learndr.learndr.vocabulary.infrastructure.repository.spec;

import com.learndr.learndr.vocabulary.infrastructure.persistence.entity.WordJpaEntity;
import  org.springframework.data.jpa.domain.Specification;
public final class WordSpecs {
  private WordSpecs(){}
  
  public static Specification<WordJpaEntity> learnedEq (Boolean learned) {
    if (learned == null) return null;
    return (root, query, cb) -> cb.equal(root.get("learned"), learned);
  }

  public static Specification<WordJpaEntity> textOrTranslationContains(String q){
    if (q == null || q.isBlank()) return null;
    String like = "%" + q.trim().toLowerCase() +"%";
    return (root, query, cb) -> cb.or(
      cb.like(cb.lower(root.get("word")), like),
      cb.like(cb.lower(root.get("meaning")), like)
    );  
  }
}
