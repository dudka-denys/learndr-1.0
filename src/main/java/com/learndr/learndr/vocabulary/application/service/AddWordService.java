package com.learndr.learndr.vocabulary.application.service;

import org.springframework.stereotype.Service;

import com.learndr.learndr.vocabulary.application.dto.command.*;
import com.learndr.learndr.vocabulary.application.dto.result.WordOutput;
import com.learndr.learndr.vocabulary.application.port.in.AddWordUseCase;
import com.learndr.learndr.vocabulary.domain.repository.WordRepository;
import com.learndr.learndr.vocabulary.domain.entity.Word;

@Service
public class AddWordService implements AddWordUseCase {
  private final WordRepository wordRepository;

  public AddWordService(WordRepository wordRepository) {
    this.wordRepository = wordRepository;
  }

  @Override
  public WordOutput execute(AddWordCommand cmd) {
    Word word = new Word(
        cmd.word(),
        cmd.meaning(),
        cmd.context());

    Word saved = wordRepository.save(word);

    return new WordOutput(
        saved.getId(),
        saved.getWord(),
        saved.getMeaning(),
        saved.getContext(),
        saved.getLearnProgressPercentage(),
        saved.getIsLearned(),
        saved.getCreatedAt());
  }
}