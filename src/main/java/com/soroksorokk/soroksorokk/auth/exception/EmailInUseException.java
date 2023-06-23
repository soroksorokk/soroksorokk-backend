package com.soroksorokk.soroksorokk.auth.exception;

import com.soroksorokk.soroksorokk.exception.BusinessException;
import com.soroksorokk.soroksorokk.exception.ErrorMessage;
import lombok.Getter;

@Getter
public class EmailInUseException extends BusinessException {
    public static final ErrorMessage error = ErrorMessage.EMAIL_ALREADY_IN_USE;

    public EmailInUseException() {
        super(error);
    }
}
