package com.learndr.learndr.vocabulary.infrastructure.persistence.mapper;

import java.util.List;

import org.springframework.data.domain.Page;

import com.learndr.learndr.vocabulary.application.dto.result.WordOutput;
import com.learndr.learndr.vocabulary.application.model.query.WordsPage;
import com.learndr.learndr.vocabulary.infrastructure.persistence.entity.WordJpaEntity;

public final class WordJpaMapper {
  public static WordsPage toApplication(Page<WordJpaEntity> e) {
    List<WordOutput> res_list = e.getContent().stream()
        .map(WordJpaMapper::toWordOutput)
        .toList();

    WordsPage res = new WordsPage(
    res_list,
    e.getNumber(),
    e.getSize(),
    e.getTotalElements()
    );
    return res;
  }

  private static WordOutput toWordOutput(WordJpaEntity word) {
    return new WordOutput(
            word.getId(),
            word.getWord(),
            word.getMeaning(),
            word.getContext(),
            word.getLearnProgressPercentage(),
            word.getIsLearned(),
            word.getCreatedAt());
  }
}
