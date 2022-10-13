package com.sparta.board.dto.request;

import com.sparta.board.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CommentRequestDto {

    private String username;
    private String desc;

    public CommentRequestDto(Comment comment){
        this.username = comment.getUsername();
        this.desc = comment.getDesc();
    }
}
