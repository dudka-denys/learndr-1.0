package com.learndr.learndr.vocabulary.application.port.in;

import com.learndr.learndr.vocabulary.application.dto.command.DeleteWordCommand;

public interface DeleteWordUseCase {
  public void execute(DeleteWordCommand cmd);
}
