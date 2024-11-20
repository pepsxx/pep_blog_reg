package ru.pepsxx.pep_blog_reg.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.pepsxx.pep_blog_reg.dto.UserDtoException;
import ru.pepsxx.pep_blog_reg.exception.ObjectNotValidated;
import ru.pepsxx.pep_blog_reg.exception.UserAlreadyExists;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(ObjectNotValidated.class)
    ResponseEntity<UserDtoException> objectNotValidated(ObjectNotValidated objectNotValidated) {
        return ResponseEntity.badRequest().body(objectNotValidated.getUserDtoException());
    }
    @ExceptionHandler(UserAlreadyExists.class)
    ResponseEntity<UserDtoException> userAlreadyExists(UserAlreadyExists userAlreadyExists) {
        return ResponseEntity.badRequest().body(userAlreadyExists.getUserDtoException());
    }

}
