package com.soroksorokk.soroksorokk.user.dto.response;

public record GetUserResponseDto(
        Long id,
        String nickname,
        String email,
        String img
) {

}
