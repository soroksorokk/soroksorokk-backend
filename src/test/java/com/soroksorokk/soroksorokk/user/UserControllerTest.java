package com.soroksorokk.soroksorokk.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soroksorokk.soroksorokk.user.dto.request.EmailRequestDto;
import com.soroksorokk.soroksorokk.user.dto.request.NicknameRequestDto;
import com.soroksorokk.soroksorokk.user.service.ValidateUserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles(profiles = "test")
@WebMvcTest(value = UserController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
class UserControllerTest {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mvc;

    @MockBean
    ValidateUserInfoService validateUserInfoService;

    @Test
    void 이메일_중복_검사_200() throws Exception{
        // given
        // when
        this.mvc.perform(post("/users/validate/email")
                        .content(objectMapper.writeValueAsString(new EmailRequestDto("email@emai.com")))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        //then
    }

    @Test
    void 닉네임_중복_검사_200() throws Exception{
        // given
        // when
        this.mvc.perform(post("/users/validate/email")
                        .content(objectMapper.writeValueAsString(new NicknameRequestDto("nickname")))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        //then
    }
}