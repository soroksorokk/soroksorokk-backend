package com.soroksorokk.soroksorokk.category.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetAllCategoriesResponseDto {
    private final Long id;
    private final String name;
}
