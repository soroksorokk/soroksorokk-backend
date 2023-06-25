package com.soroksorokk.soroksorokk.category.service;

import com.soroksorokk.soroksorokk.category.exception.DuplicatedCategoryNameException;
import com.soroksorokk.soroksorokk.category.repository.CategoryRepository;
import com.soroksorokk.soroksorokk.persist.entities.CategoryEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
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
}
