package com.learndr.learndr.auth.application.dto.command;

public record AddUserCommand(
    String user_name,
    String email,
    String preferred_locale,
    String password) {

}
