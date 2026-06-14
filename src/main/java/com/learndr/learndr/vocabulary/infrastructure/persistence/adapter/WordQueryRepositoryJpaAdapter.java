package com.learndr.learndr.vocabulary.infrastructure.persistence.adapter;

import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.PageRequest;

import com.learndr.learndr.vocabulary.application.model.WordPageRequest;
import com.learndr.learndr.vocabulary.application.model.WordSearchCriteria;
import com.learndr.learndr.vocabulary.application.model.WordsPage;
import com.learndr.learndr.vocabulary.application.port.out.WordQueryPort;
import com.learndr.learndr.vocabulary.infrastructure.repository.SpringDataWordRepository;
import com.learndr.learndr.vocabulary.infrastructure.repository.spec.WordSpecs;

import com.learndr.learndr.vocabulary.infrastructure.persistence.entity.WordJpaEntity;
import com.learndr.learndr.vocabulary.infrastructure.persistence.mapper.WordJpaMapper;

@Repository
public class WordQueryRepositoryJpaAdapter implements WordQueryPort {
  private static final String DEFAULT_SORT_FIELD = "createdAt";
  private static final Map<String, String> SORT_FIELD_ALIASES = Map.ofEntries(
      Map.entry("createdAt", "createdAt"),
      Map.entry("created_at", "createdAt"));

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
      return Sort.by(Sort.Direction.DESC, DEFAULT_SORT_FIELD);
    }

    String[] parts = sort.split(",");
    String requestedField = parts[0].trim();
    String field = SORT_FIELD_ALIASES.getOrDefault(requestedField, DEFAULT_SORT_FIELD);

    Sort.Direction dir = (parts.length > 1 && "asc".equalsIgnoreCase(parts[1].trim()))
        ? Sort.Direction.ASC
        : Sort.Direction.DESC;

    return Sort.by(dir, field);
  }

  private Specification<WordJpaEntity> buildSpecification(WordSearchCriteria criteria) {
    return Specification.where(WordSpecs.textOrTranslationContains(criteria.text())).and(WordSpecs.learnedEq(criteria.learned()));
  }
}
