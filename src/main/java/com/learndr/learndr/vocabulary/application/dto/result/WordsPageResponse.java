package com.learndr.learndr.vocabulary.application.dto.result;
import java.util.List;

import com.learndr.learndr.vocabulary.domain.entity.Word;

public record WordsPageResponse(
    List<WordOutput> words,
    int page,
    int size,
    long totalElements
) {
  public int getTotalPages() {
    if (size == 0) return 0;
    return (int)Math.ceil((double) totalElements /(double) size);
  }
}
