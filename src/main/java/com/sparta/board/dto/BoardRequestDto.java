package com.sparta.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BoardRequestDto {

    private String title;
    private String writer;
    private String date;
    private String password;
    private String desc;

    public BoardRequestDto(String title, String writer, String date, String password, String desc){
        this.title = title;
        this.writer = writer;
        this.date = date;
        this.password = password;
        this.desc = desc;
    }
}
