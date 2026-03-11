package com.learndr.learndr.vocabulary.application.dto.command;

import com.learndr.learndr.vocabulary.domain.entity.WordId;

public record DeleteWordCommand(WordId id) {
  
}
