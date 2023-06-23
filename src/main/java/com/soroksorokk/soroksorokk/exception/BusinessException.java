package com.soroksorokk.soroksorokk.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {
    private final HttpStatus status;

    protected BusinessException(ErrorMessage error) {
        super(error.getMsg());
        this.status = error.getStatus();
    }
}
