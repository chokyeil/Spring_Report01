package com.sparta.board.service;

import com.sparta.board.dto.BoardListResponseDto;
import com.sparta.board.dto.BoardPwCheckRequestDto;
import com.sparta.board.dto.BoardRequestDto;
import com.sparta.board.dto.BoardResponseDto;
import com.sparta.board.entity.Board;
import com.sparta.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class BoardService {

    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final BoardRepository boardRepository;

    // 게시판 전체 조회
    public List<BoardListResponseDto> boardList(){
        //List<Board> boardList = boardRepository.findAll();
        List<Board> boardList = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        return boardList.stream().map(BoardListResponseDto::new).collect(Collectors.toList());
    }

    // 특정 게시판 조회
    public BoardRequestDto boardOne(Long id){
        Board boardOne = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        return new BoardRequestDto(boardOne);
    }

    // 게시판 생성
    public BoardResponseDto create(BoardRequestDto requestDto){
        Board board = new Board(requestDto);
        boardRepository.save(board);
        return new BoardResponseDto(board);
    }

    // 게시판 수정
    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        board.update(requestDto);
        return board.getId();
    }

    // 게시판 삭제
    public BoardResponseDto delete(Long id){
        boardRepository.deleteById(id);
        return new BoardResponseDto();
    }

    // 게시판 비밀번호 일치 여부 확인
    public BoardResponseDto pwCheck(Long id, BoardPwCheckRequestDto pwCheckRequestDto){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(("해당 아이디가 존재하지 않습니다."))
        );
        if(!board.getPassword().equals(pwCheckRequestDto.getPassword()))
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");

        return new BoardResponseDto(board);
    }

}