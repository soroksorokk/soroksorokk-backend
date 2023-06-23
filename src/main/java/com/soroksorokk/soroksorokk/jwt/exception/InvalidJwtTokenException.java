package com.soroksorokk.soroksorokk.jwt.exception;

import com.soroksorokk.soroksorokk.exception.BusinessException;
import com.soroksorokk.soroksorokk.exception.ErrorMessage;

public class InvalidJwtTokenException extends BusinessException {
    public static ErrorMessage error = ErrorMessage.INVALID_JWT_TOKEN;

    public InvalidJwtTokenException() {
        super(error);
    }
}
