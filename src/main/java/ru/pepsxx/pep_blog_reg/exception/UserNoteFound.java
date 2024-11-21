package ru.pepsxx.pep_blog_reg.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class UserNoteFound extends RuntimeException {

    public UserNoteFound(String message) {
        super(message);
        log.error(message);
    }
}
