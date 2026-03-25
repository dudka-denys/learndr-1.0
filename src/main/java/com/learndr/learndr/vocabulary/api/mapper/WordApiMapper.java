package com.learndr.learndr.vocabulary.api.mapper;

import com.learndr.learndr.vocabulary.api.dto.response.WordResponseDto;
import com.learndr.learndr.vocabulary.application.dto.result.WordOutput;

public class WordApiMapper {
  public static WordResponseDto toWordResponseDTO(WordOutput res) {
    return new WordResponseDto(
        res.id().value(),
        res.word(),
        res.meaning(),
        res.context(),
        res.learnProgressPercentage(),
        res.isLearned(),
        res.createdAt());
  }
}