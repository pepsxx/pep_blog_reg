package ru.pepsxx.pep_blog_reg.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class userController {

    @GetMapping("test")
    public ResponseEntity<String> test (){
        return ResponseEntity.ok("Test Ok");
    }

}
