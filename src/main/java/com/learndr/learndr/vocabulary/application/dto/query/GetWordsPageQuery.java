package com.learndr.learndr.vocabulary.application.dto.query;

import java.lang.IllegalArgumentException;

public record GetWordsPageQuery(
    int page,
    int size,
    String sort,
    String searchSubStr) {
  public GetWordsPageQuery {
    if (page < 0)
      throw new IllegalArgumentException("Page must be >=0");
    if (size < 0 || size > 200)
      throw new IllegalArgumentException("Size must be between 0 and 200");
    if (sort == null || sort.isBlank())
      sort = "createdAt,desc";
    if (searchSubStr == null)
      searchSubStr = "";
  }
}
