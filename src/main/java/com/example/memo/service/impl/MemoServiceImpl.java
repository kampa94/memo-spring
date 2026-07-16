package com.example.memo.service.impl;

import com.example.memo.dto.request.MemoRequestDto;
import com.example.memo.dto.response.MemoResponseDto;
import com.example.memo.service.MemoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoServiceImpl implements MemoService {

    @Override
    public MemoResponseDto create(MemoRequestDto requestDto) {
        return null;
    }

    @Override
    public MemoResponseDto getById(long id) {
        return null;
    }

    @Override
    public List<MemoResponseDto> getAll() {
        return List.of();
    }

    @Override
    public MemoResponseDto update(MemoRequestDto user) {
        return null;
    }

    @Override
    public void delete(MemoRequestDto user) {

    }
}
