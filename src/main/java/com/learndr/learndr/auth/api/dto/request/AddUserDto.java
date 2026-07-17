package com.learndr.learndr.auth.api.dto.request;

public record AddUserDto(
    String userName,
    String email,
    String preferredLocale,
    String password,
    long roleId) {

}