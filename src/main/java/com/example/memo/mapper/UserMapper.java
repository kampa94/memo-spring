package com.example.memo.mapper;

import com.example.memo.dto.request.UserRequestDto;
import com.example.memo.dto.response.UserResponseDto;
import com.example.memo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }
        User user = new User();
        user.setName(requestDto.getName());
        user.setMail(requestDto.getMail());
        return user;
    }

    public UserResponseDto toResponseDto(User user) {
        if (user == null) {
            return null;
        }
        UserResponseDto dto = new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getMail());
        return dto;
    }
}
