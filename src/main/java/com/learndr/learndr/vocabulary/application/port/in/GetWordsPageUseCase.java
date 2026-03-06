package com.learndr.learndr.vocabulary.application.port.in;

import com.learndr.learndr.vocabulary.application.dto.query.GetWordsPageQuery;
import com.learndr.learndr.vocabulary.application.dto.result.WordsPageResponse;

public interface GetWordsPageUseCase {
  WordsPageResponse execute(GetWordsPageQuery getWordsPageQuery);
}
