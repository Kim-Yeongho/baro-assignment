package com.baro.baro_assignment.auth.controller;

import com.baro.baro_assignment.auth.model.dto.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthController {

    @PostMapping("/signup")
    public PostSignupResDto signup(@RequestBody PostSignupReqDto requestDto) {
        AuthorityDto authority = new AuthorityDto("USER");
        List<AuthorityDto> authorities = new ArrayList<>();
        authorities.add(authority);
        PostSignupResDto response = new PostSignupResDto("JIN HO", "Memtos", authorities);
        return response;
    }

    @PostMapping("/sign")
    public PostSignResDto sign(@RequestBody PostSignReqDto requestDto) {
        PostSignResDto response = new PostSignResDto("Token");
        return response;
    }
}
