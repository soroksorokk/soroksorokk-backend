package com.soroksorokk.soroksorokk.feed.exception;

import com.soroksorokk.soroksorokk.exception.BusinessException;
import com.soroksorokk.soroksorokk.exception.ErrorMessage;

public class NotFeedWriterException extends BusinessException {
    public static ErrorMessage error = ErrorMessage.NOT_FEED_WRITER;

    public NotFeedWriterException() {
        super(error);
    }
}
