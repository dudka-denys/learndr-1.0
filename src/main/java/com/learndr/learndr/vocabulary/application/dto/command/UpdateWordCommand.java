package com.learndr.learndr.vocabulary.application.dto.command;

import com.learndr.learndr.vocabulary.domain.entity.WordId;

public record UpdateWordCommand(
    WordId id,
    String word,
    String meaning,
    String context,
    Boolean isLearned) {

}
