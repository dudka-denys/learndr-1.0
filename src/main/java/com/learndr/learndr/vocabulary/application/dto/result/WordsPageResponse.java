package com.learndr.learndr.vocabulary.application.dto.result;

import java.util.List;

public record WordsPageResponse(
    List<WordOutput> words,
    int page,
    int size,
    long totalElements) {
  public int getTotalPages() {
    if (size == 0)
      return 0;
    return (int) Math.ceil((double) totalElements / (double) size);
  }

  public boolean hasPrevious() {
    return page > 0;
  }

  public boolean hasNext() {
    return page + 1 < getTotalPages();
  }
}
