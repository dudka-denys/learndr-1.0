package com.learndr.learndr.vocabulary.api.dto.request;

import org.openapitools.jackson.nullable.JsonNullable;

public record UpdateWordRequestDto(
    JsonNullable<String> word,
    JsonNullable<String> meaning,
    JsonNullable<String> context,
    Boolean isLearned) {

}
