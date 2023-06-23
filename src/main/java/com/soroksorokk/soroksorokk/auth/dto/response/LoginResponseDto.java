package com.soroksorokk.soroksorokk.auth.dto.response;

import com.soroksorokk.soroksorokk.jwt.JwtToken;

public record LoginResponseDto(JwtToken jwtToken) {
}
