package com.learndr.learndr.vocabulary.application.port.in;

import com.learndr.learndr.vocabulary.application.dto.command.UpdateWordCommand;
import com.learndr.learndr.vocabulary.application.dto.result.WordOutput;

public interface UpdateWordUseCase {
  WordOutput execute(UpdateWordCommand cmd);
}
