package com.baro.baro_assignment.auth.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    String username;
    String password;
    String nickname;
    UserRole role;
    String refreshToken;
    String accessToken;

    public User(String username, String password, String nickname, UserRole role) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
        this.refreshToken = null;
        this.accessToken = null;
    }

}
