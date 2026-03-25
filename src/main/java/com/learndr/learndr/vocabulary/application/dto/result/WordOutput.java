package com.learndr.learndr.vocabulary.application.dto.result;

import java.time.Instant;

import com.learndr.learndr.vocabulary.domain.entity.WordId;

public record WordOutput(
    WordId id,
    String word,
    String meaning,
    String context,
    int learnProgressPercentage,
    boolean isLearned,
    Instant createdAt) {
}
