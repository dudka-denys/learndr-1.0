package com.learndr.learndr.vocabulary.api.dto.request;

import org.openapitools.jackson.nullable.JsonNullable;

public record UpdateWordRequestDto(
    String word,
    String meaning,
    String context,
    Boolean isLearned) {

}
