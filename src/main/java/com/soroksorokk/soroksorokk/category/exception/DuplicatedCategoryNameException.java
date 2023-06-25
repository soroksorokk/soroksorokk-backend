package com.soroksorokk.soroksorokk.category.exception;

import com.soroksorokk.soroksorokk.exception.BusinessException;
import com.soroksorokk.soroksorokk.exception.ErrorMessage;

public class DuplicatedCategoryNameException extends BusinessException {
    public static ErrorMessage error = ErrorMessage.DUPLICATED_CATEGORY_NAME;

    public DuplicatedCategoryNameException() {
        super(error);
    }
}
