package com.example.memo.mapper;

import com.example.memo.dto.request.MemoRequestDto;
import com.example.memo.dto.response.MemoResponseDto;
import com.example.memo.entity.Memo;
import org.springframework.stereotype.Component;

@Component
public class MemoMapper {
    public Memo toEntity(MemoRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }
        Memo memo = new Memo();
        memo.setTitle(requestDto.getTitle());
        memo.setContent(requestDto.getContent());
        return memo;
    }

    public MemoResponseDto toResponseDto(Memo memo) {
        if (memo == null) {
            return null;
        }
        MemoResponseDto dto = new MemoResponseDto(
                memo.getId(),
                memo.getTitle(),
                memo.getContent()
        );
        return dto;
    }
}
