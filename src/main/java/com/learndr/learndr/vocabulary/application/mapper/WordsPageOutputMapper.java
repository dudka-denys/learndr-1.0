package com.learndr.learndr.vocabulary.application.mapper;

import java.util.List;

import com.learndr.learndr.vocabulary.application.dto.result.WordOutput;
import com.learndr.learndr.vocabulary.application.dto.result.WordsPageResponse;
import com.learndr.learndr.vocabulary.application.model.query.WordsPage;

public class WordsPageOutputMapper {
   public static WordsPageResponse toWordsPageResponse(WordsPage res) {
    // List<WordOutput> words_res = res 
    
    return new WordsPageResponse();


    // this.words = words.stream()
    //     .map(word -> new WordOutput(
    //         word.getId(),
    //         word.getWord(),
    //         word.getMeaning(),
    //         word.getContext(),
    //         word.getLearnProgressPercentage(),
    //         word.isLearned(),
    //         word.getCreatedAt()
    //     )).toList();
    // this.page = page;
    // this.size = size;
    // this.totalElements = totalElements;
  }
}
