package com.learndr.learndr.vocabulary.application.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class VerifyUpdatingWord {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void shouldUpdateWord() throws Exception {
    String json = """
        {
          "isLearned":false
        }
        """;
    mockMvc.perform(patch("/api/words/{id}", 1)
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(status().isOk());
  }
}