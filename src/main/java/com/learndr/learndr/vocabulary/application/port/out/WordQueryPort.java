package com.learndr.learndr.vocabulary.application.port.out;

import com.learndr.learndr.vocabulary.application.model.WordPageRequest;
import com.learndr.learndr.vocabulary.application.model.WordSearchCriteria;
import com.learndr.learndr.vocabulary.application.model.WordsPage;

public interface WordQueryPort {
  WordsPage getWordsPage(WordPageRequest wordPageRequest, WordSearchCriteria criteria);
}
