package ru.pepsxx.pep_blog_reg.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestException extends RuntimeException {
    public TestException(String message) {
        log.error(message);
    }
}
