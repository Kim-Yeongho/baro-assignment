package com.baro.baro_assignment.auth.controller;

import com.baro.baro_assignment.auth.model.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Auth", description = "인증 관련 API")
@RestController
public class AuthController {

    @Operation(summary = "회원가입 요청", description = "회원가입 요청 API 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "회원가입 성공", content = @Content(schema = @Schema(implementation = PostSignupResDto.class))),
    })
    @PostMapping("/signup")
    public PostSignupResDto signup(@RequestBody PostSignupReqDto requestDto) {
        AuthorityDto authority = new AuthorityDto("USER");
        List<AuthorityDto> authorities = new ArrayList<>();
        authorities.add(authority);
        PostSignupResDto response = new PostSignupResDto("JIN HO", "Memtos", authorities);
        return response;
    }

    @Operation(summary = "로그인 요청", description = "로그인 요청 API 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "로그인 성공", content = @Content(schema = @Schema(implementation = PostSignResDto.class))),
    })
    @PostMapping("/sign")
    public PostSignResDto sign(@RequestBody PostSignReqDto requestDto, Errors errors) {
        PostSignResDto response = new PostSignResDto("Token");
        return response;
    }
}
