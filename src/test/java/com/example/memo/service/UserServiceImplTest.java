package com.example.memo.service;

import com.example.memo.dto.request.UserRequestDto;
import com.example.memo.dto.response.UserResponseDto;
import com.example.memo.exception.ResourceNotFoundException;
import com.example.memo.mapper.UserMapper;
import com.example.memo.entity.User;
import com.example.memo.repository.UserRepository;
import com.example.memo.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;
    private UserRequestDto requestDto;
    private UserResponseDto responseDto;

    @BeforeEach
    void setUp() {
        user = new User(1L, "Francesco", "francesco@test.com", "hashedpwd");
        requestDto = new UserRequestDto("Francesco", "francesco@test.com", "password123");
        responseDto = new UserResponseDto(1L, "Francesco", "francesco@test.com");
    }

    @Test
    void create_shouldSaveAndReturnUser() {
        when(userMapper.toEntity(requestDto)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        when(userMapper.toResponseDto(user)).thenReturn(responseDto);

        UserResponseDto result = userService.create(requestDto);

        assertThat(result).isEqualTo(responseDto);
        verify(userRepository).save(user);
    }

    @Test
    void getById_shouldReturnUser_whenExists() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userMapper.toResponseDto(user)).thenReturn(responseDto);

        UserResponseDto result = userService.getById(1L);

        assertThat(result.id()).isEqualTo(1L);
        assertThat(result.email()).isEqualTo("francesco@test.com");
    }

    @Test
    void getById_shouldThrow_whenNotFound() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> userService.getById(99L))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("99");
    }

    @Test
    void getAll_shouldReturnListOfUsers() {
        when(userRepository.findAll()).thenReturn(List.of(user));
        when(userMapper.toResponseDto(user)).thenReturn(responseDto);

        List<UserResponseDto> result = userService.getAll();

        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualTo(responseDto);
    }
}