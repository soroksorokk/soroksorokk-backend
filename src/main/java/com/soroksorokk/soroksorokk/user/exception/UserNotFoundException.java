package com.soroksorokk.soroksorokk.user.exception;

import com.soroksorokk.soroksorokk.exception.BusinessException;
import com.soroksorokk.soroksorokk.exception.ErrorMessage;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BusinessException {
    public static ErrorMessage error = ErrorMessage.USER_NOT_FOUND;

    public UserNotFoundException() {
        super(error);
    }
}
