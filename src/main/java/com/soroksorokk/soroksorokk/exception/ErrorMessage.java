package com.soroksorokk.soroksorokk.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorMessage {
    USER_NOT_FOUND("유저정보를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    EMAIL_ALREADY_IN_USE("사용중인 이메일 입니다.", HttpStatus.BAD_REQUEST),
    NICKNAME_ALREADY_IN_USE("사용중인 닉네임 입니다.", HttpStatus.BAD_REQUEST),
    INVALID_EMAIL_OR_PASSWORD("이메일 혹은 비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST),
    INVALID_JWT_TOKEN("유요한 JWT가 아닙니다.", HttpStatus.BAD_REQUEST);

    final String msg;
    final HttpStatus status;

    ErrorMessage(String msg, HttpStatus status) {
        this.msg = msg;
        this.status = status;
    }
}
