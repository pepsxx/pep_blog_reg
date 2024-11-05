package ru.pepsxx.pep_blog_reg.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.pepsxx.pep_blog_reg.dto.userDto;
import ru.pepsxx.pep_blog_reg.validator.UserDtoValidator;

import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class userController {

    private final UserDtoValidator userDtoValidator;

    @GetMapping("test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test Ok");
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody @Valid userDto userDto, BindingResult bindingResult) {
        userDtoValidator.validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            String message = "Поле: " +
                    Objects.requireNonNull(bindingResult.getFieldError()).getField() + " - " +
                    bindingResult.getFieldError().getDefaultMessage();
            log.error(message);
            return ResponseEntity.badRequest().body(message);
        }
        log.info(userDto.toString());
        return ResponseEntity.ok().body(userDto.toString());
    }

}
