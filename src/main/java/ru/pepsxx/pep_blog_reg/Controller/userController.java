package ru.pepsxx.pep_blog_reg.Controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.pepsxx.pep_blog_reg.dto.userDto;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class userController {

    @GetMapping("test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test Ok");
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody @Valid userDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Поле: " +
                    bindingResult.getFieldError().getField() + " - " +
                    bindingResult.getFieldError().getDefaultMessage());
        }
        log.info(userDto.toString());
        return ResponseEntity.ok().body(userDto.toString());
    }

}
