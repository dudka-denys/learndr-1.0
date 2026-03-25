package com.learndr.learndr.vocabulary.domain.repository;

import com.learndr.learndr.vocabulary.domain.entity.Word;
import com.learndr.learndr.vocabulary.domain.entity.WordId;

public interface WordRepository {
  Word save(Word word);
  boolean existsById(WordId id);
  void deleteById(WordId id);
  Word findById(WordId id);
}
