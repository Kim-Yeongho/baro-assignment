package com.baro.baro_assignment.auth.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class PostSignupResDto {

    private String username;
    private String nickname;
    private List<AuthorityDto> authorities = new ArrayList<>();

}
