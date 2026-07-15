package com.example.memo.service;

import com.example.memo.dto.request.UserRequestDto;
import com.example.memo.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto create(UserRequestDto requestDto);
    UserResponseDto getById(long id);
    List<UserResponseDto> getAll();

}
