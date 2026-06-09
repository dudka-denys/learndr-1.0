package com.learndr.learndr.auth.application.port;

import com.learndr.learndr.auth.application.dto.command.AddUserCommand;

public interface AddUserUseCase {
  public void execute(AddUserCommand cmd);
}
