package ru.pepsxx.pep_blog_reg.dto;

import java.util.List;

public record userDto(
        String name,
        String email,
        String pass,
        List<roleDto> roleList) {
}
