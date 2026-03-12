package com.learndr.learndr.vocabulary.application.service;

import org.springframework.stereotype.Service;

import com.learndr.learndr.vocabulary.application.dto.command.DeleteWordCommand;
import com.learndr.learndr.vocabulary.application.port.in.DeleteWordUseCase;
import com.learndr.learndr.vocabulary.domain.entity.WordId;
import com.learndr.learndr.vocabulary.domain.repository.WordRepository;

@Service
public class DeleteWordService implements DeleteWordUseCase {
  WordRepository wordRepository;

  public DeleteWordService(WordRepository wordRepository) {
    this.wordRepository = wordRepository;
  }

  @Override
  public void execute(DeleteWordCommand cmd) {
    WordId id = new WordId(cmd.id());
    if (wordRepository.existsById(id))
      wordRepository.deleteById(id);
  }
}
