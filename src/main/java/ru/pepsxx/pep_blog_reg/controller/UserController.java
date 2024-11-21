package ru.pepsxx.pep_blog_reg.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.pepsxx.pep_blog_reg.dto.IdModel;
import ru.pepsxx.pep_blog_reg.dto.UserDto;
import ru.pepsxx.pep_blog_reg.dto.UserDtoException;
import ru.pepsxx.pep_blog_reg.exception.UserNotValidated;
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
                    .filter(error -> error instanceof FieldError)
                    .map(FieldError.class::cast)
                    .collect(Collectors.toMap(
                            FieldError::getField,
                            field -> Optional.ofNullable(field.getDefaultMessage()).orElse("")));
            throw new UserNotValidated(new UserDtoException("Validation Errors", errorsMap));

        }

        userDto = userService.registerUser(userDto);
        log.info("User registered: {}", userDto);
        return ResponseEntity.ok().body(userDto);
    }

    @PostMapping("search_in_body")
    public ResponseEntity<UserDto> searchInBody(@RequestBody IdModel idModel) {
        UserDto userDto = userService.findUserById(idModel);
        loggingUserSearches(userDto);
        return ResponseEntity.ok().body(userDto);
    }

    @GetMapping("search_in_path/{id}")
    public ResponseEntity<UserDto> searchInPath(@PathVariable Long id) {
        IdModel idModel = new IdModel(id);
        UserDto userDto = userService.findUserById(idModel);
        loggingUserSearches(userDto);
        return ResponseEntity.ok().body(userDto);
    }

    @GetMapping("search_in_param")
    public ResponseEntity<UserDto> searchInParam(@RequestParam Long id) {
        IdModel idModel = new IdModel(id);
        UserDto userDto = userService.findUserById(idModel);
        loggingUserSearches(userDto);
        return ResponseEntity.ok().body(userDto);
    }

    @GetMapping("search_in_model")
    public ResponseEntity<UserDto> searchInModel(@ModelAttribute IdModel idModel) {
        UserDto userDto = userService.findUserById(idModel);
        loggingUserSearches(userDto);
        return ResponseEntity.ok().body(userDto);
    }

    private static void loggingUserSearches(UserDto userDto) {
        log.info("User searched: {}", userDto);
    }

}


