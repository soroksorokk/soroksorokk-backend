package com.soroksorokk.soroksorokk.user.exception;

import com.soroksorokk.soroksorokk.exception.BusinessException;
import com.soroksorokk.soroksorokk.exception.ErrorMessage;

public class NicknameInUseException extends BusinessException {
    public static ErrorMessage error = ErrorMessage.NICKNAME_ALREADY_IN_USE;

    public NicknameInUseException() {
        super(error);
    }

}
