package com.intro.springsecurityintro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greetings")
public class GreetingsController {
    
    @GetMapping
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring Security!";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "Goodbye!";
    }
}
