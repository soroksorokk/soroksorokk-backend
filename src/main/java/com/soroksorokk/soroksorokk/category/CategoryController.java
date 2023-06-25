package com.soroksorokk.soroksorokk.category;

import com.soroksorokk.soroksorokk.category.dto.request.CreateCategoryRequestDto;
import com.soroksorokk.soroksorokk.category.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createCategory(CreateCategoryRequestDto request) {
        categoryService.createCategory(request.categoryName());
    }
}
