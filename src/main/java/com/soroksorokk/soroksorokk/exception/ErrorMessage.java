package com.soroksorokk.soroksorokk.exception;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    USER_NOT_FOUND("유저정보를 찾을 수 없습니다.");

    final String msg;

    ErrorMessage(String msg) {
        this.msg = msg;
    }
}
