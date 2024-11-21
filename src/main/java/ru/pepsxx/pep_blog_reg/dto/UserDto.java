package ru.pepsxx.pep_blog_reg.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;
import java.util.Set;

public record UserDto(
        @NotBlank
        String name,
        @Email
        @NotBlank
        String email,
        String pass,
        String passwordRepeat,
        Timestamp dataTimeRegistering,
        Set<UserRoleDto> roles) {
}
