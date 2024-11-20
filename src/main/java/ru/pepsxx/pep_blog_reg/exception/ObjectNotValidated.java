package ru.pepsxx.pep_blog_reg.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import ru.pepsxx.pep_blog_reg.dto.UserDtoException;

import java.util.stream.Collectors;

@Slf4j
@Getter
public class ObjectNotValidated extends RuntimeException {

    private final UserDtoException userDtoException;

    public ObjectNotValidated(UserDtoException userDtoException) {
        super(userDtoException.message());
        this.userDtoException = userDtoException;
        log.error(userDtoException.errorsMap()
                .entrySet()
                .stream()
                .map(e -> "%n%-10s - %s".formatted(e.getKey(), e.getValue()))
                .collect(Collectors.joining(""))
        );
    }

}
