package com.example.learnspringbasics.controllers;

import com.example.learnspringbasics.entity.User;
import com.example.learnspringbasics.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/{userId}")
    public User getById(@PathVariable(name = "userId") Long id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable(name = "userId") Long id) {
        userService.deleteById(id);
    }
}
