package com.learndr.learndr.auth.api.exceptions.dto;

public record ApiError(
    String code,
    String message) {
}
