package com.sparta.board.dto;

import com.sparta.board.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class BoardRequestDto {
    private String title;
    private String writer;
    private String password;
    private String desc;
//    private LocalDateTime createdAt;

    public BoardRequestDto(Board board){
        this.title = board.getTitle();
        this.writer = board.getWriter();
        this.password = board.getPassword();
        this.desc = board.getDesc();
//        this.createdAt = board.get
    }
}
