package com.sparta.board.dto.response;

import com.sparta.board.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class CommentListResponseDto {

    private String username;
    private String desc;
    private LocalDateTime createdAt;

    public CommentListResponseDto(Comment comment){
        this.username = comment.getUsername();
        this.desc = comment.getDesc();
        this.createdAt = comment.getCreatedAt();
    }
}
