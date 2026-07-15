package com.example.memo.controller;

import com.example.memo.dto.request.UserRequestDto;
import com.example.memo.dto.response.UserResponseDto;
import com.example.memo.entity.User;
import com.example.memo.mapper.UserMapper;
import com.example.memo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private UserRequestDto requestDto;
    private UserResponseDto responseDto;
    private User user;

    @BeforeEach
    void setUp() {
        user = new User(1L, "Francesco", "francesco@test.com", "hashedpwd");
        requestDto = new UserRequestDto("Francesco", "francesco@test.com", "password123");
        responseDto = new UserResponseDto(1L, "Francesco", "francesco@test.com");
    }

    @Test
    void shouldGetUser() {
        when(userService.getById(1L)).thenReturn(responseDto);
        UserResponseDto risultato = userController.getById(1L);
        assertThat(risultato.getId()).isEqualTo(1L);
        assertThat(risultato.getNome()).isEqualTo("Francesco");
    }
}