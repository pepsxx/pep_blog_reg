package ru.pepsxx.pep_blog_reg.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserAlreadyExists extends RuntimeException {
    public UserAlreadyExists(String message) {
        super(message);
    }
}
