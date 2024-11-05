package ru.pepsxx.pep_blog_reg.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record userDto(
        @NotBlank
        String name,
        @Email
        String email,
        String pass,
        List<roleDto> roleList) {
}
