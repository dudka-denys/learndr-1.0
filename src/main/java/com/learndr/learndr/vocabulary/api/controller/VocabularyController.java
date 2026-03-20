package com.learndr.learndr.vocabulary.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import com.learndr.learndr.vocabulary.application.dto.command.*;
import com.learndr.learndr.vocabulary.application.dto.query.*;
import com.learndr.learndr.vocabulary.application.port.in.*;
import com.learndr.learndr.vocabulary.api.dto.request.*;
import com.learndr.learndr.vocabulary.api.dto.response.*;
import com.learndr.learndr.vocabulary.api.mapper.*;;

@Controller
@Validated
public class VocabularyController {
  private final AddWordUseCase AddWordUseCase;
  private final GetWordsPageUseCase getWordsPageUseCase;
  private final DeleteWordUseCase deleteWordUseCase;

  public VocabularyController(
      AddWordUseCase AddWordUseCase,
      GetWordsPageUseCase GetWordsPageUseCase,
      DeleteWordUseCase DeleteWordUseCase) {
    this.AddWordUseCase = AddWordUseCase;
    this.getWordsPageUseCase = GetWordsPageUseCase;
    this.deleteWordUseCase = DeleteWordUseCase;
  }

  @GetMapping("/vocabulary")
  public String vocabulary() {
    return "vocabulary/vocab-list";
  }

  @GetMapping("/api/words")
  public ResponseEntity<WordsPageDtoResponse> getWords(
      @RequestParam int page,
      @RequestParam int size,
      @RequestParam String sort,
      @RequestParam String searchSubStr,
    @RequestParam Boolean isLearned) {
    GetWordsPageQuery query = new GetWordsPageQuery(page, size, sort, searchSubStr);
    WordsPageDtoResponse response = WordsPageDtoMapper.toDTO(getWordsPageUseCase.execute(query));
    return ResponseEntity.ok(response);
  }

  @PostMapping("/api/words")
  public ResponseEntity<WordResponseDto> addWord(@Valid @RequestBody CreateWordRequestDto req) {
    AddWordCommand command = new AddWordCommand(
        req.word(),
        req.meaning(),
        req.context());

    WordResponseDto response = WordApiMapper.toWordResponseDTO(AddWordUseCase.execute(command));

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  // return 204
  @DeleteMapping("/api/words/{id}")
  public ResponseEntity deleteWord(@PathVariable @Positive long id) {
    deleteWordUseCase.execute(new DeleteWordCommand(id));
    return ResponseEntity.noContent().build();
  }

}
