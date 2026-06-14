package com.learndr.learndr.auth.api.dto.request;

public record UserDto(
    String userName,
    String email,
    String preferredLocale,
    String password) {

}
