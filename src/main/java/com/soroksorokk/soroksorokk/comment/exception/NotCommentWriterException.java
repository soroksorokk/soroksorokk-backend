package com.soroksorokk.soroksorokk.comment.exception;

import com.soroksorokk.soroksorokk.exception.BusinessException;
import com.soroksorokk.soroksorokk.exception.ErrorMessage;

public class NotCommentWriterException extends BusinessException {
    public static ErrorMessage error = ErrorMessage.NOT_COMMENT_WRITER;
    public NotCommentWriterException() {
        super(error);
    }
}
