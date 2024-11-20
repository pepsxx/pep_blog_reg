package ru.pepsxx.pep_blog_reg.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.pepsxx.pep_blog_reg.dto.UserDto;
import ru.pepsxx.pep_blog_reg.exception.ObjectNotValidated;
import ru.pepsxx.pep_blog_reg.service.UserService;
import ru.pepsxx.pep_blog_reg.validator.UserDtoValidator;

import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    private final UserDtoValidator userDtoValidator;

    @PostMapping("register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {

        userDtoValidator.validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getAllErrors()
                    .stream()
                    .filter(e -> e instanceof FieldError)
                    .map(FieldError.class::cast)
                    .map(e -> "Поле: %s - %s".formatted(e.getField(), e.getDefaultMessage()))
                    .peek(log::error)
                    .collect(Collectors.joining("\n"));
            throw new ObjectNotValidated(message);
        }

        return ResponseEntity.ok().body(userService.getUser(userDto));
    }
}


