package ru.pepsxx.pep_blog_reg.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.pepsxx.pep_blog_reg.exception.ObjectNotValidated;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(ObjectNotValidated.class)
    ResponseEntity<String> handleTestException(ObjectNotValidated e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
