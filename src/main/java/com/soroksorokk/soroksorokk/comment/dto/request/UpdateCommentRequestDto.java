package com.soroksorokk.soroksorokk.comment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class UpdateCommentRequestDto {
    private final String text;
}
