package ru.pepsxx.pep_blog_reg.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.pepsxx.pep_blog_reg.exception.ObjectNotValidated;
import ru.pepsxx.pep_blog_reg.exception.UserAlreadyExists;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(ObjectNotValidated.class)
    ResponseEntity<String> objectNotValidated(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler(UserAlreadyExists.class)
    ResponseEntity<String> userAlreadyExists(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
