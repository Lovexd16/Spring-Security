package com.springsecurityapp.sslogin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurityapp.sslogin.model.User;
import com.springsecurityapp.sslogin.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Hämtar alla användare
    @GetMapping
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    //Hämtar en specifik användare
    @GetMapping("/{id}")
    public User findById(@PathVariable("id") User user) {
        return user;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

}
