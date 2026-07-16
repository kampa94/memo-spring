package com.example.memo.service.impl;

import com.example.memo.dto.request.MemoRequestDto;
import com.example.memo.dto.response.MemoResponseDto;
import com.example.memo.mapper.MemoMapper;
import com.example.memo.repository.MemoRepository;
import com.example.memo.service.MemoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoServiceImpl implements MemoService {
    private MemoMapper memoMapper;
    private MemoRepository memoRepository;

    public MemoServiceImpl(MemoMapper memoMapper, MemoRepository memoRepository) {
        this.memoMapper = memoMapper;
        this.memoRepository = memoRepository;
    }

    @Override
    public MemoResponseDto create(MemoRequestDto requestDto) {
        return null;
    }

    @Override
    public MemoResponseDto getById(long id) {
        return memoRepository.findById(id)
                .map(memoMapper::toResponseDto)
                .orElse(null);
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
