package ru.pepsxx.pep_blog_reg.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> register(@RequestBody userDto userDto) {
        log.info(userDto.toString());
        return ResponseEntity.ok("Register Ok");
    }

}
