package com.baro.baro_assignment.auth.service;

import com.baro.baro_assignment.auth.infrastructure.util.JwtUtil;
import com.baro.baro_assignment.auth.model.User;
import com.baro.baro_assignment.auth.model.UserRole;
import com.baro.baro_assignment.auth.model.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class AuthService {

    public Map<String,User> users = new HashMap<String,User>();
    private PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;

    public PostSignupResDto createMember(PostSignupReqDto requestDto) {
        User user = new User(
                requestDto.getUsername(),
                passwordEncoder.encode(requestDto.getPassword()),
                requestDto.getNickname(),
                UserRole.ROLE_USER
        );
        users.put(user.getUsername(), user);

        AuthorityDto authority = new AuthorityDto(UserRole.ROLE_USER.name());
        List<AuthorityDto> authorities = new ArrayList<>();
        authorities.add(authority);

        return new PostSignupResDto(user.getUsername(), user.getNickname(), authorities);
    }


    public PostSignResDto checkMember(PostSignReqDto requestDto) {
        User user = users.get(requestDto.getUsername());

        if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            log.info("Password match failed.");
            return null;
        }
        log.info("Encrypted password match completed.");

        String refreshToken = jwtUtil.generateRefreshToken(user.getNickname(), user.getRole());
        users.get(requestDto.getUsername()).setRefreshToken(refreshToken);
        String accessToken = jwtUtil.generateAccessToken(user.getNickname(), user.getRole());
        users.get(requestDto.getUsername()).setAccessToken(accessToken);

        return new PostSignResDto(accessToken);
    }
}
