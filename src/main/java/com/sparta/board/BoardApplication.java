package com.sparta.board;

import com.sparta.board.repository.BoardRepository;
import com.sparta.board.service.BoardService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BoardRepository boardRepository, BoardService boardService) {
        return (args) -> {
//            boardRepository.save(new Board("게시글03", "테스터03", "2022-09-03", "4387", "작성내용03"));
//
//            System.out.println("데이터 인쇄");
//            List<Board> boardList = boardRepository.findAll();
//            for (int i=0; i<boardList.size(); i++) {
//                Board board = boardList.get(i);
//                System.out.println(board.getId());
//                System.out.println(board.getTitle());
//                System.out.println(board.getWriter());
//                System.out.println(board.getDate());
//                System.out.println(board.getPassword());
//                System.out.println(board.getDesc());
//            }
//
//            BoardRequestDto requestDto = new BoardRequestDto("게시글04", "테스터04", "2022-09-04", "5764", "작성내용04");
//            boardService.update(1L, requestDto);
//            boardList = boardRepository.findAll();
//            for (int i=0; i<boardList.size(); i++) {
//                Board board = boardList.get(i);
//                System.out.println(board.getId());
//                System.out.println(board.getTitle());
//                System.out.println(board.getWriter());
//                System.out.println(board.getDate());
//                System.out.println(board.getPassword());
//                System.out.println(board.getDesc());
//            }
//
//            boardRepository.deleteAll();
        };
    }
}
