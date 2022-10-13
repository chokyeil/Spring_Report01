package com.sparta.board.dto.request;

import com.sparta.board.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BoardRequestDto {
    private String title;
    private String writer;
    private String password;
    private String desc;

    public BoardRequestDto(Board board){
        this.title = board.getTitle();
        this.writer = board.getWriter();
        this.password = board.getPassword();
        this.desc = board.getDesc();
    }
}
