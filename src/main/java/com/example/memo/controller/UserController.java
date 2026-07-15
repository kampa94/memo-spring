package com.example.memo.controller;

import com.example.memo.dto.response.UserResponseDto;
import com.example.memo.entity.User;
import com.example.memo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserResponseDto getById(@PathVariable Long id) {
        return userService.getById(id);
    }
    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.getAll();
    }
}