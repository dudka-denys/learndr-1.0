package com.learndr.learndr.vocabulary.application.mapper;

import com.learndr.learndr.vocabulary.application.dto.result.WordsPageResponse;
import com.learndr.learndr.vocabulary.application.model.WordsPage;

public class WordsPageOutputMapper {
  public static WordsPageResponse toWordsPageResponse(WordsPage res) {
    WordsPageResponse inbound_res = new WordsPageResponse(
        res.words(),
        res.page(),
        res.size(),
        res.totalElements());
    return inbound_res;
  }
}
