package com.learndr.learndr.vocabulary.api.mapper;

import java.util.List;

import com.learndr.learndr.vocabulary.api.dto.response.WordResponseDto;
import com.learndr.learndr.vocabulary.api.dto.response.WordsPageDtoResponse;
import com.learndr.learndr.vocabulary.application.dto.result.WordOutput;
import com.learndr.learndr.vocabulary.application.dto.result.WordsPageResponse;

public class WordsPageDtoMapper {
  public static WordsPageDtoResponse toDTO(WordsPageResponse res) {
    List<WordResponseDto> words = res.words().stream()
        .map(WordsPageDtoMapper::toWordDTO)
        .toList();
    return new WordsPageDtoResponse(
        words,
        res.page(),
        res.size(),
        res.totalElements(),
        res.getTotalPages(),
        res.hasNext(),
        res.hasPrevious());

  }

  public static WordResponseDto toWordDTO(WordOutput word) {
    return new WordResponseDto(
        word.id(),
        word.word(),
        word.meaning(),
        word.context(),
        word.learnProgressPercentage(),
        word.isLearned(),
        word.createdAt());
  }
}
