package com.sparta.board.service;

import com.sparta.board.dto.request.UserSignupRequestDto;
import com.sparta.board.dto.response.UserSignupResponseDto;
import com.sparta.board.entity.User;
import com.sparta.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserSignupResponseDto signUp(UserSignupRequestDto requestDto){
        String username = requestDto.getUsername();
        Optional<User> foundUsername = userRepository.findByUsername(username);
        if (foundUsername.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }

        // 패스워드 암호화
        String password = requestDto.getPassword();
        String email = requestDto.getEmail();

        User user = new User(username, password, email);
        userRepository.save(user);
        return new UserSignupResponseDto(user);
    }

    public UserSignupResponseDto login(UserSignupRequestDto requestDto) {
        User user = userRepository.findByUsername(requestDto.getUsername()).orElseThrow(
                () -> new IllegalArgumentException(("아이디가 일치하지 않습니다."))
        );

        if(!user.getPassword().equals(requestDto.getPassword())){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return new UserSignupResponseDto(user);
    }
}
