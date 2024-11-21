package ru.pepsxx.pep_blog_reg.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.pepsxx.pep_blog_reg.dto.UserDtoException;
import ru.pepsxx.pep_blog_reg.exception.UserNotValidated;
import ru.pepsxx.pep_blog_reg.exception.UserAlreadyExists;
import ru.pepsxx.pep_blog_reg.exception.UserNoteFound;

import java.util.Map;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserNotValidated.class)
    ResponseEntity<UserDtoException> objectNotValidated(UserNotValidated userNotValidated) {
        return ResponseEntity.badRequest().body(userNotValidated.getUserDtoException());
    }

    @ExceptionHandler(UserAlreadyExists.class)
    ResponseEntity<UserDtoException> userAlreadyExists(UserAlreadyExists userAlreadyExists) {
        return ResponseEntity.badRequest().body(userAlreadyExists.getUserDtoException());
    }

    @ExceptionHandler(UserNoteFound.class)
    ResponseEntity<String> userNoteFound(UserNoteFound userNoteFound) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userNoteFound.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<UserDtoException> httpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException) {
        UserDtoException body = new UserDtoException("HttpMessageNotReadableException",
                Map.of("HttpMessageNotReadableException", httpMessageNotReadableException.getMessage()));
        return ResponseEntity.badRequest().body(body);
    }

}
