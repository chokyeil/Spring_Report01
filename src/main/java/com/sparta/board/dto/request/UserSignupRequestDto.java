package com.sparta.board.dto.request;

import com.sparta.board.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class UserSignupRequestDto {

    // @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z]).{4,12}", message = "아이디는 4~12자 영문 대 소문자, 숫자를 사용하세요.")
    private String username;
    // @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z]).{4,32}", message = "비밀번호는 4~32자 영문 대 소문자, 숫자를 사용하세요.")
    private String password;
    private String email;

    public UserSignupRequestDto(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }

}
