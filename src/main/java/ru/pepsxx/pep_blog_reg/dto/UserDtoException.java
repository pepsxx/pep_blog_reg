package ru.pepsxx.pep_blog_reg.dto;

import java.util.Map;

public record UserDtoException(
        String message, Map<String, String> errorsMap) {
}