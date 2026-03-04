package com.learndr.learndr.vocabulary.application.port.in;

import com.learndr.learndr.vocabulary.application.dto.query.GetWordsPageQuery;
import com.learndr.learndr.vocabulary.application.model.query.WordsPage;

public interface GetWordsPageUseCase {
  WordsPage execute(GetWordsPageQuery getWordsPageQuery);
} 
