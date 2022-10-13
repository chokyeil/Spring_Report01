package com.sparta.board.dto.response;

import com.sparta.board.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CommentResponseDto {

    private String username;
    private String desc;

    public CommentResponseDto(Comment comment){
        this.username = comment.getUsername();
        this.desc = comment.getDesc();
    }
}
