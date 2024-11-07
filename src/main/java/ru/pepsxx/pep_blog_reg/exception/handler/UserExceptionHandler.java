package ru.pepsxx.pep_blog_reg.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.pepsxx.pep_blog_reg.exception.TestException;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(TestException.class)
    ResponseEntity<String> handleTestException(TestException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
