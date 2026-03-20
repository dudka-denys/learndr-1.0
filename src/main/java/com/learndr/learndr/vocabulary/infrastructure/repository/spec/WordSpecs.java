package com.learndr.learndr.vocabulary.infrastructure.repository.spec;

import com.learndr.learndr.vocabulary.infrastructure.persistence.entity.WordJpaEntity;
import org.springframework.data.jpa.domain.Specification;

public final class WordSpecs {
  private WordSpecs() {
  }

  public static Specification<WordJpaEntity> learnedEq(Boolean learned) {
    return (root, query, cb) -> {
      if (learned == null)
        return cb.conjunction();
      return cb.equal(root.get("is_learned"), learned);
    };
  }

  public static Specification<WordJpaEntity> textOrTranslationContains(String q) {

    String like = "%" + q.trim().toLowerCase() + "%";
    return (root, query, cb) -> {
      if (q == null || q.isBlank())
        return cb.conjunction();
      return cb.or(
          cb.like(cb.lower(root.get("word")), like),
          cb.like(cb.lower(root.get("meaning")), like));
    };
  }
}
