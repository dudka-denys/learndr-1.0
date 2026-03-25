package com.learndr.learndr.vocabulary.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learndr.learndr.vocabulary.application.dto.command.UpdateWordCommand;
import com.learndr.learndr.vocabulary.application.dto.result.WordOutput;
import com.learndr.learndr.vocabulary.application.port.in.UpdateWordUseCase;
import com.learndr.learndr.vocabulary.domain.entity.Word;
import com.learndr.learndr.vocabulary.domain.repository.WordRepository;

@Service
@Transactional
public class UpdateWordService implements UpdateWordUseCase {
  private final WordRepository wordRepository;

  public UpdateWordService(WordRepository wordRepository) {
    this.wordRepository = wordRepository;
  }

  @Override
  public WordOutput execute(UpdateWordCommand cmd) {
    Word repositoryWord = wordRepository.findById(cmd.id());

    if (cmd.word().isPresent())
      repositoryWord.changeWordValue(cmd.word().get());
    if (cmd.meaning().isPresent())
      repositoryWord.changeMeaning(cmd.meaning().get());
    if (cmd.context().isPresent())
      repositoryWord.changeContext(cmd.context().get());
    if (cmd.isLearned())
      repositoryWord.changeIsLearned(cmd.isLearned().booleanValue());

    Word saved = wordRepository.save(repositoryWord);
    return new WordOutput(saved.getId(),
        saved.getWord(),
        saved.getMeaning(),
        saved.getContext(),
        saved.getLearnProgressPercentage(),
        saved.getIsLearned(),
        saved.getCreatedAt());
  }
}
