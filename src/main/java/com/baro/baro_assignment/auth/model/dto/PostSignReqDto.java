package com.baro.baro_assignment.auth.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostSignReqDto {
    private String username;
    private String password;
}
