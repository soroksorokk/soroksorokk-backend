package com.soroksorokk.soroksorokk.auth.service;

import com.soroksorokk.soroksorokk.auth.dto.request.SignupRequestDto;
import com.soroksorokk.soroksorokk.auth.dto.response.LoginResponseDto;


public interface AuthUseCase {
    LoginResponseDto login(String email, String password);
    void signup(SignupRequestDto request);
}
