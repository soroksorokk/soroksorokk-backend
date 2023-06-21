package com.soroksorokk.soroksorokk.auth.dto.request;

// TODO: 2023/06/20 Record는 무엇인가? dto로 사용해도 되는지 알아보고 수정
// 2023/06/21 Record는 필드를 불변으로 생성,
public record SignupRequestDto(String nickname,
                               String email,
                               String password,
                               String img
) {
}
