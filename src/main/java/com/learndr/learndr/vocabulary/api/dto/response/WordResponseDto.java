package com.learndr.learndr.vocabulary.api.dto.response;

import java.time.Instant;

import com.learndr.learndr.vocabulary.domain.entity.WordId;

public record WordResponseDto(
    WordId id,
    String word,
    String meaning,
    String context,
    int learnProgressPercentage,
    boolean isLearned,
    Instant createdAt) {
  
}
