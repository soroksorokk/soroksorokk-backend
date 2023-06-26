package com.soroksorokk.soroksorokk.comment.exception;

import com.soroksorokk.soroksorokk.exception.BusinessException;
import com.soroksorokk.soroksorokk.exception.ErrorMessage;

public class CommentNotFoundException extends BusinessException {
    public static ErrorMessage error = ErrorMessage.COMMENT_NOT_FOUND;

    public CommentNotFoundException() {
        super(error);
    }
}
