package com.baro.baro_assignment.controller;

import com.baro.baro_assignment.BaroAssignmentApplication;
import com.baro.baro_assignment.auth.controller.AuthController;
import com.baro.baro_assignment.auth.infrastructure.util.JwtUtil;
import com.baro.baro_assignment.auth.model.User;
import com.baro.baro_assignment.auth.model.UserRole;
import com.baro.baro_assignment.auth.model.dto.PostSignReqDto;
import com.baro.baro_assignment.auth.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.springframework.web.bind.annotation.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = BaroAssignmentApplication.class)
@AutoConfigureMockMvc
public class AuthControllerTest {
    @Autowired
    private AuthService authService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthController authController;

    @Autowired
    private JwtUtil jwtUtil;
    private final String VALUE_BEARER_PREFIX = "Bearer ";

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() throws Exception {
        User user = new User(
                "JIN HO",
                passwordEncoder.encode("12341234"),
                "Mentos",
                UserRole.ROLE_USER
        );
        authService.users.put(user.getUsername(), user);

    }

    @Test
    public void IfUserExistsThenGetUserInfoReturnsSuccess() throws Exception {
        PostSignReqDto loginRequest = new PostSignReqDto("JIN HO", "12341234");

        MvcResult result = mockMvc.perform(post("/sign")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isOk())
                .andReturn();  // 200 응답 코드 확인

        JSONObject response = new JSONObject(result.getResponse().getContentAsString());
        assertTrue(response.get("token").toString().startsWith(VALUE_BEARER_PREFIX));
    }


}
