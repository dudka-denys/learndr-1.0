package com.learndr.learndr.vocabulary.api.dto.request;

public record UpdateWordRequestDto(
    String word,
    String meaning,
    String context,
    Boolean isLearned) {

}
