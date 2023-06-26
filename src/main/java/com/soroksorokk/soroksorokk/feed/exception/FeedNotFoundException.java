package com.soroksorokk.soroksorokk.feed.exception;

import com.soroksorokk.soroksorokk.exception.BusinessException;
import com.soroksorokk.soroksorokk.exception.ErrorMessage;

public class FeedNotFoundException extends BusinessException {
    public static ErrorMessage error = ErrorMessage.FEED_NOT_FOUND;

    public FeedNotFoundException() {
        super(error);
    }
}
