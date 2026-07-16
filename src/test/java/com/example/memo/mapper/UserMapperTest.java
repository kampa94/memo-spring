package com.example.memo.mapper;

import com.example.memo.dto.request.UserRequestDto;
import com.example.memo.dto.response.UserResponseDto;
import com.example.memo.entity.User;
import com.example.memo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class UserMapperTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserMapper userMapper;

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
    void shouldReturnUserEntity() {
        var result = userMapper.toEntity(requestDto);
        assertThat(result).isInstanceOf(User.class);
    }

    @Test
    void shouldReturnUserResponseDto() {
        var result = userMapper.toResponseDto(user);
        assertThat(result).isInstanceOf(UserResponseDto.class);
    }
}