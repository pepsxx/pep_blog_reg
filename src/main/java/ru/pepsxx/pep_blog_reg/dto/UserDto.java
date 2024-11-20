package ru.pepsxx.pep_blog_reg.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDto(
        @NotBlank
        String name,
        @Email
        String email,
        String pass,
        UserRoleDto userRole) {
}
