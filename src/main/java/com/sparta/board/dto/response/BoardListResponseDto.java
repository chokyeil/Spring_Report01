package com.sparta.board.dto.response;

import com.sparta.board.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardListResponseDto {
    private String title;
    private String writer;
    private LocalDateTime createdAt;

    public BoardListResponseDto(Board board){
        this.title = board.getTitle();
        this.writer = board.getWriter();
        this.createdAt = board.getCreatedAt();
    }
}
