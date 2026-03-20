package com.learndr.learndr.vocabulary.api.dto.response;

import java.util.List;

public record WordsPageDtoResponse(
  List<WordResponseDto> wordsDto,
    int page,
    int size,
    long totalElements,
    int totalPages,
    boolean hasNext,
    boolean hasPrevious
) {
  
}
