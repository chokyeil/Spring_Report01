package com.sparta.board.entity;

import com.sparta.board.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Board extends Timestamped{

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String desc;

    public Board(String title, String writer, String date, String password, String desc){
        this.title = title;
        this.writer = writer;
        this.date = date;
        this.password = password;
        this.desc = desc;
    }

    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.date = requestDto.getDate();
        this.password = requestDto.getPassword();
        this.desc = requestDto.getDesc();
    }


    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.date = requestDto.getDate();
        this.password = requestDto.getPassword();
        this.desc = requestDto.getDesc();
    }
}
