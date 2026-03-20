package com.learndr.learndr.vocabulary.application.service;

import org.springframework.stereotype.Service;

import com.learndr.learndr.vocabulary.application.dto.query.GetWordsPageQuery;
import com.learndr.learndr.vocabulary.application.dto.result.WordsPageResponse;
import com.learndr.learndr.vocabulary.application.mapper.WordsPageOutputMapper;
import com.learndr.learndr.vocabulary.application.model.WordPageRequest;
import com.learndr.learndr.vocabulary.application.model.WordSearchCriteria;
import com.learndr.learndr.vocabulary.application.port.in.GetWordsPageUseCase;
import com.learndr.learndr.vocabulary.application.port.out.WordQueryPort;

@Service
public class GetWordsPageService implements GetWordsPageUseCase {
  private final WordQueryPort wordQueryPort;

  public GetWordsPageService(WordQueryPort wordQueryPort) {
    this.wordQueryPort = wordQueryPort;
  }

  @Override
  public WordsPageResponse execute(GetWordsPageQuery getWordsPageQuery) {
    WordPageRequest pageRequest = new WordPageRequest(
        getWordsPageQuery.page(),
        getWordsPageQuery.size(),
        getWordsPageQuery.sort());
    WordSearchCriteria criteria = new WordSearchCriteria(getWordsPageQuery.searchSubStr(), getWordsPageQuery.isLearned());
    return WordsPageOutputMapper.toWordsPageResponse(wordQueryPort.getWordsPage(pageRequest, criteria));
  }
}
