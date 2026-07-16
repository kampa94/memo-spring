package com.example.memo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemoResponseDto {
    private Long id;
    private String title;
    private String content;
}
