package com.soroksorokk.soroksorokk.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soroksorokk.soroksorokk.auth.dto.request.EmailRequestDto;
import com.soroksorokk.soroksorokk.auth.dto.request.LoginRequestDto;
import com.soroksorokk.soroksorokk.auth.dto.request.SignupRequestDto;
import com.soroksorokk.soroksorokk.auth.service.AuthService;
import com.soroksorokk.soroksorokk.exception.GlobalExceptionHandler;
import com.soroksorokk.soroksorokk.user.service.ValidateUserInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles(profiles = "test")
@WebMvcTest(value = AuthController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class AuthControllerTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mvc;

    @MockBean
    AuthService authService;

    @MockBean
    ValidateUserInfoService validateUserInfoService;

    @Test
        void 회원가입_201() throws Exception {
        // given
        // when
        this.mvc.perform(post("/auth/signup")
                .content(objectMapper.writeValueAsString(new SignupRequestDto("nickname", "email@email.com", "password",
                ""       ))).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        //then
        }
    @Test
        void 이메일_중복_검사_200() throws Exception{
        // given
        // when
        this.mvc.perform(post("/auth/signup/validate/email")
                .content(objectMapper.writeValueAsString(new EmailRequestDto("email@emai.com")))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        //then
        }

    @Test
    void login() throws Exception {
        // given
        // when
        this.mvc.perform(post("/auth/signup/validate/email")
                        .content(objectMapper.writeValueAsString(new LoginRequestDto("email@email.com", "password")))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        //then
    }
}
