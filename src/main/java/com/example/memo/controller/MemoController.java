package com.example.memo.controller;

import com.example.memo.dto.request.MemoRequestDto;
import com.example.memo.dto.response.MemoResponseDto;
import com.example.memo.service.MemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/memo")
public class MemoController {
    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    public MemoResponseDto getById(long l) {
        return memoService.getById(l);
    }

    public List<MemoResponseDto> getAll() {
        return List.of();
    }

    public MemoController update(MemoRequestDto newRequestDto) {
        return null;
    }

    public String getTitle() {
        return null;
    }
}
