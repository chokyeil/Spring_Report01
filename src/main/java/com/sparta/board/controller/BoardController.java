package com.sparta.board.controller;

import com.sparta.board.dto.BoardListResponseDto;
import com.sparta.board.dto.BoardPwCheckRequestDto;
import com.sparta.board.dto.BoardRequestDto;
import com.sparta.board.dto.BoardResponseDto;
import com.sparta.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 게시글 전체 조회
    @GetMapping("/api/boards")
    public List<BoardListResponseDto> BoardList() {
        return boardService.boardList();
    }

    // 특정 게시글 조회
    @GetMapping("/api/boards/one/{id}")
    public BoardRequestDto BoardOne(@PathVariable Long id) {
        return boardService.boardOne(id);
    }

    // 게시글 생성
    @PostMapping("/api/boards")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto) {
        return boardService.create(requestDto);
    }

    // 게시글 수정
    @PutMapping("/api/boards/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.update(id, requestDto);
    }

    // 게시글 삭제
    @DeleteMapping("/api/boards/{id}")
    public BoardResponseDto deleteBoard(@PathVariable Long id) {
        return boardService.delete(id);
    }

    // 게시글 비밀번호 일치 여부 확인
    @PostMapping("/api/boards/password/{id}")
    public BoardResponseDto passwordCheck(@PathVariable Long id, @RequestBody BoardPwCheckRequestDto pwCheckRequestDto){
        return boardService.pwCheck(id, pwCheckRequestDto);
    }
}
