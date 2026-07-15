package com.example.memo.service.impl;

import com.example.memo.dto.request.UserRequestDto;
import com.example.memo.dto.response.UserResponseDto;
import com.example.memo.entity.User;
import com.example.memo.mapper.UserMapper;
import com.example.memo.repository.UserRepository;
import com.example.memo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        User user = userRepository.findById(l).orElse(null);
        return userMapper.toResponseDto(user);
    }

    public List<UserResponseDto> getAll() {
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(user -> userMapper.toResponseDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto update(UserRequestDto userRequestDto) {
        User user = userMapper.toEntity(userRequestDto);
        User savedUser = userRepository.save(user);
        return userMapper.toResponseDto(savedUser);
    }

    @Override
    public void delete(UserRequestDto userRequestDto) {
        User user = userMapper.toEntity(userRequestDto);
        userRepository.delete(user);
    }
}
