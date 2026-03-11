package com.learndr.learndr.vocabulary.application.service;

import org.springframework.stereotype.Service;

import com.learndr.learndr.vocabulary.application.dto.command.DeleteWordCommand;
import com.learndr.learndr.vocabulary.application.port.in.DeleteWordUseCase;

@Service
public class DeleteWordService implements DeleteWordUseCase{
  @Override
  public void execute(DeleteWordCommand cmd) {

  }
}
