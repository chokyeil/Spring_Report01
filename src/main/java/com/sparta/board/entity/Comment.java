package com.sparta.board.entity;

import com.sparta.board.dto.request.CommentRequestDto;
import com.sparta.board.util.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "comments")
@NoArgsConstructor
@Getter
public class Comment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String desc;

    public Comment(CommentRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.desc = requestDto.getDesc();
    }

    public void update(CommentRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.desc = requestDto.getDesc();
    }
}
