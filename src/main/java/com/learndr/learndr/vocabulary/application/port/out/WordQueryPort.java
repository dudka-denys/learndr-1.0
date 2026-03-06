package com.learndr.learndr.vocabulary.application.port.out;

import com.learndr.learndr.vocabulary.application.model.query.WordPageRequest;
import com.learndr.learndr.vocabulary.application.model.query.WordsPage;

public interface WordQueryPort {
  WordsPage getWordsPage(WordPageRequest wordPageRequest);
}
