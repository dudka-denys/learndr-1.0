package com.learndr.learndr.vocabulary.infrastructure.persistence.adapter;

import org.springframework.stereotype.Repository;

import com.learndr.learndr.vocabulary.domain.entity.Word;
import com.learndr.learndr.vocabulary.domain.entity.WordId;
import com.learndr.learndr.vocabulary.domain.repository.WordRepository;
import com.learndr.learndr.vocabulary.infrastructure.persistence.entity.WordJpaEntity;
import com.learndr.learndr.vocabulary.infrastructure.persistence.mapper.WordJpaMapper;
import com.learndr.learndr.vocabulary.infrastructure.repository.SpringDataWordRepository;

@Repository
public class WordRepositoryImpl implements WordRepository {
  private final SpringDataWordRepository jpaWordRepository;

  public WordRepositoryImpl(SpringDataWordRepository jpaWordRepository) {
    this.jpaWordRepository = jpaWordRepository;
  }

  @Override
  public Word save(Word word) {
    WordJpaEntity entityToSave = WordJpaMapper.toJpaEntity(word);

    WordJpaEntity saved = jpaWordRepository.save(entityToSave);

    return WordJpaMapper.toDomain(saved);
  }

    @Override
  public boolean existsById(WordId id) {
    return jpaWordRepository.existsById(id.value());
  }

  @Override
  public void deleteById(WordId id) {
    jpaWordRepository.deleteById(id.value());
  }
}
