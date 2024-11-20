package ru.pepsxx.pep_blog_reg.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectNotValidated extends RuntimeException {
    public ObjectNotValidated(String message) {
        super(message);
    }
}
