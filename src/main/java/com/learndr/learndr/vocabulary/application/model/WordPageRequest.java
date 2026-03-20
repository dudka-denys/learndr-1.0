package com.learndr.learndr.vocabulary.application.model;

public class WordPageRequest  {
  private final int page;
  private final int size;
  private final String sort;

  public WordPageRequest(int page, int size, String sort) {
    this.page = page;
    this.size = size;
    this.sort = sort;
  }

  public int page() {
    return page;
  }

  public int size() {
    return size;
  }

  public String sort() {
    return sort;
  }
}
