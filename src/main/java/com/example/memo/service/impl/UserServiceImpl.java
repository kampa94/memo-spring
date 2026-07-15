package com.example.memo.service.impl;

import com.example.memo.dto.request.UserRequestDto;
import com.example.memo.dto.response.UserResponseDto;
import com.example.memo.entity.User;
import com.example.memo.mapper.UserMapper;
import com.example.memo.repository.UserRepository;
import com.example.memo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    private UserRepository userRepository;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }


    public UserResponseDto create(UserRequestDto requestDto) {
        User user = userMapper.toEntity(requestDto);
        User savedUser = userRepository.save(user);
        return userMapper.toResponseDto(savedUser);
    }

    public UserResponseDto getById(long l) {
        return null;
    }

    public List<UserResponseDto> getAll() {
        return null;
    }
}
