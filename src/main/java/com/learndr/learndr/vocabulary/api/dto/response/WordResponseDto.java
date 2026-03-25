package com.learndr.learndr.vocabulary.api.dto.response;

import java.time.Instant;

public record WordResponseDto(
    Long id,
    String word,
    String meaning,
    String context,
    int learnProgressPercentage,
    boolean isLearned,
    Instant createdAt) {
  
}
