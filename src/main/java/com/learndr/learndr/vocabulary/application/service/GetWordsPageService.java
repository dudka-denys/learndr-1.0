package com.learndr.learndr.vocabulary.application.service;

import org.hibernate.query.Page;
import org.springframework.stereotype.Service;

import com.learndr.learndr.vocabulary.application.dto.query.GetWordsPageQuery;
import com.learndr.learndr.vocabulary.application.dto.result.WordsPageResponse;
import com.learndr.learndr.vocabulary.application.model.query.PageRequest;
import com.learndr.learndr.vocabulary.application.model.query.WordsPage;
import com.learndr.learndr.vocabulary.application.port.in.GetWordsPageUseCase;
import com.learndr.learndr.vocabulary.application.port.out.WordQueryPort;

@Service
public class GetWordsPageService implements GetWordsPageUseCase {
  private final WordQueryPort wordQueryPort;

  public GetWordsPageService(WordQueryPort wordQueryPort) {
    this.wordQueryPort = wordQueryPort;
  }

  @Override
  public WordsPage execute(GetWordsPageQuery getWordsPageQuery) {
    PageRequest pageRequest = new PageRequest(
        getWordsPageQuery.page(),
        getWordsPageQuery.size(),
        getWordsPageQuery.sort());
    return wordQueryPort.getWordsPage(pageRequest);
  }
}
