package com.baro.baro_assignment.auth.controller;

import com.baro.baro_assignment.auth.model.dto.PostSignReqDto;
import com.baro.baro_assignment.auth.model.dto.PostSignResDto;
import com.baro.baro_assignment.auth.model.dto.PostSignupReqDto;
import com.baro.baro_assignment.auth.model.dto.PostSignupResDto;
import com.baro.baro_assignment.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Auth", description = "인증 관련 API")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "회원가입 요청", description = "회원가입 요청 API 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "회원가입 성공", content = @Content(schema = @Schema(implementation = PostSignupResDto.class))),
    })
    @PostMapping("/signup")
    public PostSignupResDto signup(@RequestBody PostSignupReqDto requestDto) {
        return authService.createMember(requestDto);

    }

    @Operation(summary = "로그인 요청", description = "로그인 요청 API 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "로그인 성공", content = @Content(schema = @Schema(implementation = PostSignResDto.class))),
    })
    @PostMapping("/sign")
    public PostSignResDto sign(@RequestBody PostSignReqDto requestDto) {
        return authService.checkMember(requestDto);

    }
}
