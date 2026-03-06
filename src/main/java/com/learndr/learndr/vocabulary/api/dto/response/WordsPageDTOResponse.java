package com.learndr.learndr.vocabulary.api.dto.response;

import java.util.List;

public record WordsPageDTOResponse(
  List<WordResponseDTO> wordsDTO,
    int page,
    int size,
    long totalElements,
    int totalPages,
    boolean hasNext,
    boolean hasPrevious
) {
  
}
