package com.soroksorokk.soroksorokk.auth.dto.response;

// TODO: 2023/06/20 분리 예정
record JwtToken(String token) {}

public record LoginResponseDto(JwtToken jwtToken) {
}
