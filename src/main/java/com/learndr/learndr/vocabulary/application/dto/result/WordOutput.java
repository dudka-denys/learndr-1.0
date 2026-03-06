package com.learndr.learndr.vocabulary.application.dto.result;

import java.time.Instant;

public record WordOutput(
    Long id,
    String word,
    String meaning,
    String context,
    int learnProgressPercentage,
    boolean isLearned,
    Instant createdAt) {
}
