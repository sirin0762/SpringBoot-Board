package com.example.springbootboard.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostResponseDto {
    private Long userId;
    private Long postId;
    private String title;
    private String content;
}
