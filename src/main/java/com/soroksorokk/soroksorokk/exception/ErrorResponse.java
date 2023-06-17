package com.soroksorokk.soroksorokk.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Getter
public class ErrorResponse {
    private final int code;
    private final String message;
    private final String path;
    private final LocalDate timeStamp;

    public ErrorResponse(HttpStatus status, String message, LocalDate timeStamp, String path) {
        this.code = status.value();
        this.message = message;
        this.path = path;
        this.timeStamp = timeStamp;
    }
}
