package com.baro.baro_assignment.auth.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostSignupReqDto {

    private String username;
    private String password;
    private String nickname;

}
