package com.learndr.learndr.vocabulary.infrastructure.persistence.adapter;

import javax.swing.Spring;

import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;

import com.learndr.learndr.vocabulary.application.model.query.PageRequest;
import com.learndr.learndr.vocabulary.application.model.query.WordsPage;
import com.learndr.learndr.vocabulary.application.port.out.WordQueryPort;
import com.learndr.learndr.vocabulary.infrastructure.persistence.entity.WordJpaEntity;
import com.learndr.learndr.vocabulary.infrastructure.persistence.mapper.WordJpaMapper;
import com.learndr.learndr.vocabulary.infrastructure.repository.SpringDataWordRepository;

public class WordQueryRepositoryJpaAdapter implements WordQueryPort {
  private final SpringDataWordRepository jpa;
  private final WordJpaMapper mapper;

  WordQueryRepositoryJpaAdapter(SpringDataWordRepository jpa, WordJpaMapper mapper) {
    this.jpa = jpa;
  }

  @Override
  public WordsPage getWordsPage(PageRequest pageRequest) {
    Pageable pageable = PageRequest.of(
        pageRequest.page(),
        pageRequest.size(),
        parseSort(pageRequest.sort()));
    WordJpaEntity page = jpa.findAll(pageable);
    // return;
  }

  private WordsPage toItem(WordJpaEntity e) {
    WordsPage 
  }
}
