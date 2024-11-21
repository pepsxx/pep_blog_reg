package ru.pepsxx.pep_blog_reg.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.pepsxx.pep_blog_reg.dto.UserDtoException;
import ru.pepsxx.pep_blog_reg.exception.ObjectNotValidated;
import ru.pepsxx.pep_blog_reg.exception.UserAlreadyExists;

import java.util.Map;

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

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<UserDtoException> httpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException) {
        UserDtoException body = new UserDtoException("HttpMessageNotReadableException",
                Map.of("HttpMessageNotReadableException", httpMessageNotReadableException.getMessage()));
        return ResponseEntity.badRequest().body(body);
    }

}
