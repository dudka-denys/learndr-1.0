package com.learndr.learndr.vocabulary.infrastructure.persistence.adapter;

import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.PageRequest;

import com.learndr.learndr.vocabulary.application.model.query.WordPageRequest;
import com.learndr.learndr.vocabulary.application.model.query.WordSearchCriteria;
import com.learndr.learndr.vocabulary.application.model.query.WordsPage;
import com.learndr.learndr.vocabulary.application.port.out.WordQueryPort;
import com.learndr.learndr.vocabulary.infrastructure.repository.SpringDataWordRepository;
import com.learndr.learndr.vocabulary.infrastructure.repository.spec.WordSpecs;

import com.learndr.learndr.vocabulary.infrastructure.persistence.entity.WordJpaEntity;
import com.learndr.learndr.vocabulary.infrastructure.persistence.mapper.WordJpaMapper;

@Repository
public class WordQueryRepositoryJpaAdapter implements WordQueryPort {
  private static final String DEFAULT_SORT_FIELD = "created_at";
  private static final Map<String, String> SORT_FIELD_ALIASES = Map.ofEntries(
      Map.entry("createdAt", "created_at"),
      Map.entry("created_at", "created_at"));

  private final SpringDataWordRepository jpa;

  WordQueryRepositoryJpaAdapter(SpringDataWordRepository jpa) {
    this.jpa = jpa;
  }

  @Override
  public WordsPage getWordsPage(WordPageRequest wordPageRequest, WordSearchCriteria criteria) {
    Pageable pageable = PageRequest.of(
        wordPageRequest.page(),
        wordPageRequest.size(),
        parseSort(wordPageRequest.sort()));

    return WordJpaMapper.toApplication(jpa.findAll(
        buildSpecification(criteria),
        pageable));
  }

  private Sort parseSort(String sort) {
    if (sort == null || sort.isBlank()) {
      return JpaSort.unsafe(Sort.Direction.DESC, DEFAULT_SORT_FIELD);
    }

    String[] parts = sort.split(",");
    String requestedField = parts[0].trim();
    String field = SORT_FIELD_ALIASES.getOrDefault(requestedField, DEFAULT_SORT_FIELD);

    Sort.Direction dir = (parts.length > 1 && "asc".equalsIgnoreCase(parts[1].trim()))
        ? Sort.Direction.ASC
        : Sort.Direction.DESC;

    return JpaSort.unsafe(dir, field);
  }

  private Specification<WordJpaEntity> buildSpecification(WordSearchCriteria criteria) {
    return Specification.where(WordSpecs.textOrTranslationContains(criteria.text()));
  }
}