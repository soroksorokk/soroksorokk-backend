package com.soroksorokk.soroksorokk.category.service;

import com.soroksorokk.soroksorokk.category.dto.response.GetAllCategoriesResponseDto;
import com.soroksorokk.soroksorokk.category.exception.DuplicatedCategoryNameException;
import com.soroksorokk.soroksorokk.category.repository.CategoryRepository;
import com.soroksorokk.soroksorokk.feed.dto.response.GetAllFeedsResponseDto;
import com.soroksorokk.soroksorokk.persist.entities.CategoryEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public CategoryEntity getCategoryById(Long id) {
        return categoryRepository.getCategoryById(id);
    }

    @Transactional
    public void createCategory(String categoryName) {
        boolean exists = categoryRepository.existsByName(categoryName);

        if (exists) {
            throw new DuplicatedCategoryNameException();
        }

        categoryRepository.createCategory(CategoryEntity.builder()
                .name(categoryName)
                .build());
    }

    @Transactional(readOnly = true)
    public List<GetAllCategoriesResponseDto> getAllCategories() {
        List<CategoryEntity> categories = categoryRepository.getAllCategories();
        return categories.stream()
                .map(c -> new GetAllCategoriesResponseDto(c.getId(), c.getName()))
                .collect(Collectors.toList());
    }
}
