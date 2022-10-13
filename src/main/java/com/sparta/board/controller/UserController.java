package com.sparta.board.controller;

import com.sparta.board.dto.request.UserSignupRequestDto;
import com.sparta.board.dto.response.UserSignupResponseDto;
import com.sparta.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public UserSignupResponseDto userLogin(@RequestBody UserSignupRequestDto requestDto){
        return userService.login(requestDto);
    }

    @PostMapping("/signup")
    public UserSignupResponseDto userSignup(@RequestBody UserSignupRequestDto requestDto){
        return userService.signUp(requestDto);
    }

}
