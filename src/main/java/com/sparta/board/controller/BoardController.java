package com.sparta.board.controller;

import com.sparta.board.dto.response.BoardListResponseDto;
import com.sparta.board.dto.request.BoardPwCheckRequestDto;
import com.sparta.board.dto.request.BoardRequestDto;
import com.sparta.board.dto.response.BoardResponseDto;
import com.sparta.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;

    // 게시글 전체 조회
    @GetMapping("/boards")
    public List<BoardListResponseDto> boardList() {
        return boardService.boardList();
    }

    // 특정 게시글 조회
    @GetMapping("/boards/one/{id}")
    public BoardRequestDto boardOne(@PathVariable Long id) {
        return boardService.boardOne(id);
    }

    // 게시글 생성
    @PostMapping("/boards")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto) {
        return boardService.create(requestDto);
    }

    // 게시글 수정
    @PutMapping("/boards/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.update(id, requestDto);
    }

    // 게시글 삭제
    @DeleteMapping("/boards/{id}")
    public BoardResponseDto deleteBoard(@PathVariable Long id) {
        return boardService.delete(id);
    }

    // 게시글 비밀번호 일치 여부 확인
    @PostMapping("/boards/password/{id}")
    public BoardResponseDto passwordCheck(@PathVariable Long id, @RequestBody BoardPwCheckRequestDto pwCheckRequestDto){
        return boardService.pwCheck(id, pwCheckRequestDto);
    }
}
