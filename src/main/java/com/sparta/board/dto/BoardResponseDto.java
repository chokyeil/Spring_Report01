package com.sparta.board.dto;

import com.sparta.board.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BoardResponseDto {
    private Long id;
    private String title;
    private String writer;
    private String password;
    private String desc;

    // 전체 조회를 위한 생성자
    public BoardResponseDto(Board board){
        this.id = board.getId();
        this.title = board.getTitle();
        this.writer = board.getWriter();
        this.password = board.getPassword();
        this.desc = board.getDesc();
    }

}
