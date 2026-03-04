package com.learndr.learndr.vocabulary.api.dto.response;

public record WordsPageApiResponse(
    int page,
    int size,
    long totalElements,
    int totalPages,
    boolean hasNext,
    boolean hasPrevious
) {
  
}
