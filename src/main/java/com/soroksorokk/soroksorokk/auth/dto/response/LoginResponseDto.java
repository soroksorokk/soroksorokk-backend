package com.soroksorokk.soroksorokk.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

// TODO: 2023/06/20 분리 예정
record JwtToken(String token) {}

@Getter
@AllArgsConstructor
public class LoginResponseDto {
    private final JwtToken jwtToken;
}
