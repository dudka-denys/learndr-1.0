package com.learndr.learndr.auth.application.dto.command;

import com.learndr.learndr.auth.domain.entity.Locale;

public record AddUserCommand(
    String userName,
    String email,
    Locale preferredLocale,
    String password) {

}
