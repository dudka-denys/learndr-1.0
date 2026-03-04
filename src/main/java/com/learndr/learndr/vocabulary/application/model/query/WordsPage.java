package com.learndr.learndr.vocabulary.application.model.query;

import com.learndr.learndr.vocabulary.application.dto.result.WordOutput;
import java.util.List;

public record WordsPage(
    List<WordOutput> words,
    int page,
    int size,
    long totalElements) {
}