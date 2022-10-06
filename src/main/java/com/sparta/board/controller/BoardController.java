package com.sparta.board.controller;

import com.sparta.board.dto.BoardRequestDto;
import com.sparta.board.entity.Board;
import com.sparta.board.repository.BoardRepository;
import com.sparta.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    // 게시글 전체 조회
    @GetMapping("/api/boards")
    public List<Board> getBoard() {
        return boardRepository.findAll();
    }

    @GetMapping("/api/boards/one/{id}")
    public Optional<Board> getBoardOne(@PathVariable Long id) {
        Optional<Board> list = boardRepository.findById(id);
        return list;
    }


    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    // 게시글 추가
    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        // requestDto 는, 생성 요청을 의미합니다.
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
        // 그 정보를 가져오는 녀석입니다.

        // 저장하는 것은 Dto가 아니라 Board이니, Dto의 정보를 board에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.
        Board board = new Board(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return boardRepository.save(board);
    }

    // 게시글 수정
    @PutMapping("/api/boards/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.update(id, requestDto);
    }

    // 게시글 삭제
    @DeleteMapping("/api/boards/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        boardRepository.deleteById(id);
        return id;
    }
}
