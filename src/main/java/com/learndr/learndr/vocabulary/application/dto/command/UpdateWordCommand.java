package com.learndr.learndr.vocabulary.application.dto.command;

import org.openapitools.jackson.nullable.JsonNullable;

import com.learndr.learndr.vocabulary.domain.entity.WordId;

public record UpdateWordCommand(
    WordId id,
    JsonNullable<String> word,
    JsonNullable<String> meaning,
    JsonNullable<String> context,
    Boolean isLearned) {

}
