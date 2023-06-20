package com.soroksorokk.soroksorokk.auth.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

// TODO: 2023/06/20 Record는 무엇인가? dto로 사용해도 되는지 알아보고 수정
public record SignupRequsetDto(String nickname,
                               String email,
                               String password,
                               String img
) {
}
