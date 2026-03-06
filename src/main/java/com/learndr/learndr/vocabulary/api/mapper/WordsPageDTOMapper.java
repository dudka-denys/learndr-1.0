package com.learndr.learndr.vocabulary.api.mapper;

import java.util.List;

import com.learndr.learndr.vocabulary.api.dto.response.WordResponseDTO;
import com.learndr.learndr.vocabulary.api.dto.response.WordsPageDTOResponse;
import com.learndr.learndr.vocabulary.application.dto.result.WordOutput;
import com.learndr.learndr.vocabulary.application.dto.result.WordsPageResponse;

public class WordsPageDTOMapper {
  public static WordsPageDTOResponse toDTO(WordsPageResponse res) {
    List<WordResponseDTO> words = res.words().stream()
        .map(WordsPageDTOMapper::toWordDTO)
        .toList();
    return new WordsPageDTOResponse(
        words,
        res.page(),
        res.size(),
        res.totalElements(),
        res.getTotalPages(),
        res.hasNext(),
        res.hasPrevious());

  }

  public static WordResponseDTO toWordDTO(WordOutput word) {
    return new WordResponseDTO(
        word.id(),
        word.word(),
        word.meaning(),
        word.context(),
        word.learnProgressPercentage(),
        word.isLearned(),
        word.createdAt());
  }
}
