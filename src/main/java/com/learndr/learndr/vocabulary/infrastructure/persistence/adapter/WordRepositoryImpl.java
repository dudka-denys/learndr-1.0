package com.learndr.learndr.vocabulary.infrastructure.persistence.adapter;

import org.springframework.stereotype.Repository;

import com.learndr.learndr.vocabulary.domain.entity.Word;
import com.learndr.learndr.vocabulary.domain.entity.WordId;
import com.learndr.learndr.vocabulary.domain.repository.WordRepository;
import com.learndr.learndr.vocabulary.infrastructure.persistence.entity.WordJpaEntity;
import com.learndr.learndr.vocabulary.infrastructure.persistence.mapper.WordJpaMapper;
import com.learndr.learndr.vocabulary.infrastructure.repository.SpringDataWordRepository;

import jakarta.persistence.EntityNotFoundException;

@Repository
public class WordRepositoryImpl implements WordRepository {
  private final SpringDataWordRepository jpaWordRepository;

  public WordRepositoryImpl(SpringDataWordRepository jpaWordRepository) {
    this.jpaWordRepository = jpaWordRepository;
  }

  @Override
  public Word save(Word word) {
    if (word.getId() == null) {
      WordJpaEntity entityToSave = WordJpaMapper.toJpaEntity(word);
      WordJpaEntity saved = jpaWordRepository.save(entityToSave);
      return WordJpaMapper.toDomain(saved);
    } else {
      WordJpaEntity repositoryWord = jpaWordRepository.findById(word.getId().value())
          .orElseThrow(() -> new EntityNotFoundException("This word doesn't exist"));
      repositoryWord.setWord(word.getWord());
      repositoryWord.setMeaning(word.getMeaning());
      repositoryWord.setContext(word.getContext());
      repositoryWord.setIsLearned(word.getIsLearned());
      return WordJpaMapper.toDomain(repositoryWord);
    }

  }

  @Override
  public boolean existsById(WordId id) {
    return jpaWordRepository.existsById(id.value());
  }

  @Override
  public void deleteById(WordId id) {
    jpaWordRepository.deleteById(id.value());
  }

  @Override
  public Word findById(WordId id) {
    WordJpaEntity w = jpaWordRepository.findById(id.value())
        .orElseThrow(() -> new EntityNotFoundException("This word doesn't exist"));
    return WordJpaMapper.toDomain(w);
  }
}
