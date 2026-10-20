package com.learndr.learndr.auth.api.dto.request;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AddUserDto(
                @NotBlank(message = "username must not me empty") @Length(max = 255) String userName,
                @NotBlank(message = "Email must not me empty") @Email String email,
                @NotBlank(message = "Locale must not me empty") @Length(max = 2) String preferredLocale,
                @NotBlank(message = "Password must not me empty") @Length(max = 255) String password) {

}