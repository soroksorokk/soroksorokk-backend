package com.soroksorokk.soroksorokk.category.exception;

import com.soroksorokk.soroksorokk.exception.BusinessException;
import com.soroksorokk.soroksorokk.exception.ErrorMessage;

public class CategoryNotFoundException extends BusinessException {
    public static ErrorMessage error = ErrorMessage.CATEGORY_NOT_FOUND;

    public CategoryNotFoundException() {
        super(error);
    }
}
