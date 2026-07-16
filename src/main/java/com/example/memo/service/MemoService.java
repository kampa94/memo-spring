package com.example.memo.service;

import com.example.memo.dto.request.MemoRequestDto;
import com.example.memo.dto.response.MemoResponseDto;

import java.util.List;

public interface MemoService {
    MemoResponseDto create(MemoRequestDto requestDto);
    MemoResponseDto getById(long id);
    List<MemoResponseDto> getAll();
    MemoResponseDto update(MemoRequestDto user);
    void delete(MemoRequestDto user);
}
