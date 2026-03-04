package com.learndr.learndr.vocabulary.infrastructure.persistence.adapter;


import org.springframework.stereotype.Repository;

import com.learndr.learndr.vocabulary.domain.entity.Word;
import com.learndr.learndr.vocabulary.domain.entity.WordId;
import com.learndr.learndr.vocabulary.domain.repository.WordRepository;
import com.learndr.learndr.vocabulary.infrastructure.persistence.entity.WordJpaEntity;
import com.learndr.learndr.vocabulary.infrastructure.repository.SpringDataWordRepository;


@Repository
public class AddWordRepositoryImpl implements WordRepository {
  private final SpringDataWordRepository jpaWordRepository;

  public AddWordRepositoryImpl(SpringDataWordRepository jpaWordRepository) {
    this.jpaWordRepository = jpaWordRepository;
  }

  @Override
  public Word save(Word word) {
    WordJpaEntity entity;
    if (word.getId() == null) {
      entity = new WordJpaEntity(
          word.getWord(),
          word.getMeaning(),
          word.getContext());
    } else {
      entity = new WordJpaEntity(
          word.getId().value(),
          word.getWord(),
          word.getMeaning(),
          word.getContext(),
          word.getLearnProgressPercentage());
    }

    WordJpaEntity saved = jpaWordRepository.save(entity);
    return new Word(new WordId(saved.getId()), saved.getWord(), saved.getMeaning(), saved.getContext(), saved.getLearnProgressPercentage(), saved.isLearned(), saved.getCreatedAt());
  }
}
