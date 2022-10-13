package com.sparta.board.controller;

import com.sparta.board.dto.response.CommentListResponseDto;
import com.sparta.board.dto.request.CommentRequestDto;
import com.sparta.board.dto.response.CommentResponseDto;
import com.sparta.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/list")
    public List<CommentListResponseDto> commentList () {
        return commentService.commentList();
    }

    @PostMapping("/add")
    public CommentResponseDto commentAdd (@RequestBody CommentRequestDto requestDto){
        return commentService.repleAdd(requestDto);
    }

    @PutMapping("/update/{id}")
    public Long commentUpdate(@PathVariable Long id, @RequestBody CommentRequestDto requestDto){
        return commentService.update(id, requestDto);
    }

    @DeleteMapping("/delete/{id}")
    public CommentResponseDto commentDelete(@PathVariable Long id){
        return commentService.delete(id);
    }
}
