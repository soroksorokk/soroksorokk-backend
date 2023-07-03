package com.soroksorokk.soroksorokk.category;

import com.soroksorokk.soroksorokk.category.dto.request.CreateCategoryRequestDto;
import com.soroksorokk.soroksorokk.category.dto.response.GetAllCategoriesResponseDto;
import com.soroksorokk.soroksorokk.category.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createCategory(@RequestBody CreateCategoryRequestDto request) {
        categoryService.createCategory(request.categoryName());
    }

    @GetMapping
    public ResponseEntity<List<GetAllCategoriesResponseDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
