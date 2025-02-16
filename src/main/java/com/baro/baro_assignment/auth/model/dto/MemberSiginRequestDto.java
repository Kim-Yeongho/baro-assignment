package com.baro.baro_assignment.auth.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberSiginRequestDto {
    private String username;
    private String password;
}
