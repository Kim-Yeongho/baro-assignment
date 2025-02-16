package com.baro.baro_assignment.auth.model.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MemberSignupResponseDto {

    private String username;
    private String nickname;
    private List<AuthoritiesDto> authorities = new ArrayList<>();

    public MemberSignupResponseDto(String username, String nickname, AuthoritiesDto[] authorities) {
        this.username = username;
        this.nickname = nickname;
        for (AuthoritiesDto authority : authorities) {
            this.authorities.add(authority);
        }
    }


    private static class AuthoritiesDto {
        private String authorityName;
        public AuthoritiesDto(String authorityName) {
            this.authorityName = authorityName;
        }
    }



}
