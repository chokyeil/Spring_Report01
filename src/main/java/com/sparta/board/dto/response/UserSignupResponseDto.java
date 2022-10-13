package com.sparta.board.dto.response;

import com.sparta.board.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSignupResponseDto {

    private Long id;
    private String username;
    private String password;
    private String email;

    public UserSignupResponseDto(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }

}
