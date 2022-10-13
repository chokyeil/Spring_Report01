package com.sparta.board.service;

import com.sparta.board.dto.response.CommentListResponseDto;
import com.sparta.board.dto.request.CommentRequestDto;
import com.sparta.board.dto.response.CommentResponseDto;
import com.sparta.board.entity.Comment;
import com.sparta.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public List<CommentListResponseDto> commentList() {
        List<Comment> list = commentRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));

        return list.stream().map(CommentListResponseDto::new).collect(Collectors.toList());
    }

    public CommentResponseDto repleAdd(CommentRequestDto requestDto){
        Comment comment = new Comment(requestDto);
        commentRepository.save(comment);

        return new CommentResponseDto(comment);
    }


    @Transactional
    public Long update(Long id, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        comment.update(requestDto);

        return comment.getId();
    }


    public CommentResponseDto delete(Long id) {
        commentRepository.deleteById(id);
        return new CommentResponseDto();
    }
}
