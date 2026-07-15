package com.example.memo.service;

import com.example.memo.dto.request.UserRequestDto;
import com.example.memo.dto.response.UserResponseDto;
import com.example.memo.entity.User;

import java.util.List;

public interface UserService {
    UserResponseDto create(UserRequestDto requestDto);
    UserResponseDto getById(long id);
    List<UserResponseDto> getAll();
    UserResponseDto update(UserRequestDto user);
    void delete(UserRequestDto user);
}
