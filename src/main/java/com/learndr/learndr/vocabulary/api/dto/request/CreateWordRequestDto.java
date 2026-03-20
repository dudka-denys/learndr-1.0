package com.learndr.learndr.vocabulary.api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateWordRequestDto(
    @NotBlank String word,
    @NotBlank String meaning,
    String context) {
}