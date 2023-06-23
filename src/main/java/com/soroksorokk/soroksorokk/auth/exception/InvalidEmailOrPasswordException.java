package com.soroksorokk.soroksorokk.auth.exception;

import com.soroksorokk.soroksorokk.exception.BusinessException;
import com.soroksorokk.soroksorokk.exception.ErrorMessage;
import org.springframework.http.HttpStatus;

public class InvalidEmailOrPasswordException extends BusinessException {
    public static ErrorMessage error = ErrorMessage.INVALID_EMAIL_OR_PASSWORD;

    public InvalidEmailOrPasswordException() {
        super(error);
    }
}
