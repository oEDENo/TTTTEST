package com.test.board.dto.user;

import com.test.board.entity.Role;
import com.test.board.entity.User;

public class UserResponseDto {
    private String userId;
    private String password;
    private String nickname;
    private String email;
    private Role role;

    public UserResponseDto(User user){
        this.userId = user.getUserId();
        this.password = user.getPassword();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.role = user.getRole();
    }
}
