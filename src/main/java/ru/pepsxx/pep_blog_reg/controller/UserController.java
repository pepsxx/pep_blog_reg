package ru.pepsxx.pep_blog_reg.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.pepsxx.pep_blog_reg.dto.UserDto;
import ru.pepsxx.pep_blog_reg.dto.UserDtoException;
import ru.pepsxx.pep_blog_reg.exception.ObjectNotValidated;
import ru.pepsxx.pep_blog_reg.service.UserService;
import ru.pepsxx.pep_blog_reg.validator.UserDtoValidator;

import java.util.Map;
import java.util.Optional;
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

            Map<String, String> errorsMap = bindingResult.getAllErrors()
                    .stream()
                    .filter(e -> e instanceof FieldError)
                    .map(FieldError.class::cast)
                    .collect(Collectors.toMap(
                            FieldError::getField,
                            fe -> Optional.ofNullable(fe.getDefaultMessage()).orElse("")));
            throw new ObjectNotValidated(new UserDtoException("Validation Errors", errorsMap));

        }

        return ResponseEntity.ok().body(userService.registerUser(userDto));
    }
}


