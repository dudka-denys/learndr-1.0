package com.learndr.learndr.auth.application.dto.command;

import com.learndr.learndr.auth.domain.entity.Locale;
import com.learndr.learndr.auth.domain.entity.RoleId;

public record AddUserCommand(
        String userName,
        String email,
        Locale preferredLocale,
        String password,
        RoleId roleId) {

}
