package com.example.memo.dto;

import com.example.memo.controller.MemoController;
import com.example.memo.dto.request.MemoRequestDto;
import com.example.memo.dto.response.MemoResponseDto;
import com.example.memo.entity.Memo;
import com.example.memo.service.MemoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class MemoControllerTest {

    @InjectMocks
    private MemoController memoController;

    @Mock
    private MemoService memoService;

    private MemoRequestDto requestDto;
    private MemoResponseDto responseDto;
    private Memo memo;

    @BeforeEach
    void setUp() {
        memo = new Memo();
        requestDto = new MemoRequestDto();
        responseDto = new MemoResponseDto();
    }

    @Test
    void shouldGetMemo() {
        Mockito.when(memoService.getById(1L)).thenReturn(responseDto);
        MemoResponseDto result = memoController.getById(1L);
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getTitle()).isEqualTo("Titolo");
    }
    @Test
    void shouldGetAllMemos() {
        Mockito.when(memoService.getAll()).thenReturn(List.of(responseDto));
        List<MemoResponseDto> result = memoController.getAll();
        Assertions.assertThat(result).hasSize(1);
        assertThat(result.get(0).getId()).isEqualTo(1L);
        assertThat(result.get(0).getTitle()).isEqualTo("Titolo");
    }

    @Test
    void shouldUpdateMemo() {
        var newRequestDto = new MemoRequestDto();
        var newResponseDto = new MemoResponseDto();
        Mockito.when(memoService.update( newRequestDto)).thenReturn(newResponseDto);
        MemoController result = memoController.update(newRequestDto);
        assertThat(result.getById(1L)).isEqualTo(1L);
        assertThat(result.getTitle()).isEqualTo("Titolo2");
    }
}