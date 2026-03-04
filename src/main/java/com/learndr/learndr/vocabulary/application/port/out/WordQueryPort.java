package com.learndr.learndr.vocabulary.application.port.out;

import com.learndr.learndr.vocabulary.application.model.query.PageRequest;
import com.learndr.learndr.vocabulary.application.model.query.WordsPage;

public interface WordQueryPort {
    WordsPage getWordsPage(PageRequest pageRequest);
}
