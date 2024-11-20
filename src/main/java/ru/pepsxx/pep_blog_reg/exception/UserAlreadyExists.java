package ru.pepsxx.pep_blog_reg.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import ru.pepsxx.pep_blog_reg.dto.UserDtoException;

@Slf4j
@Getter
public class UserAlreadyExists extends RuntimeException {

    private final UserDtoException userDtoException;

    public UserAlreadyExists(UserDtoException userDtoException) {
        super(userDtoException.message());
        this.userDtoException = userDtoException;
        log.error(userDtoException.errorsMap().toString());
    }
}
