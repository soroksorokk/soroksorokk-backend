package com.soroksorokk.soroksorokk.category.repository;

import com.soroksorokk.soroksorokk.category.exception.CategoryNotFoundException;
import com.soroksorokk.soroksorokk.persist.entities.CategoryEntity;
import com.soroksorokk.soroksorokk.persist.repository.CategoryJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultCategoryRepository implements CategoryRepository{

    private final CategoryJpaRepository categoryRepository;

    public DefaultCategoryRepository(CategoryJpaRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryEntity createCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    @Override
    public boolean existsByName(String categoryName) {
        return categoryRepository.existsByName(categoryName);
    }

    @Override
    public CategoryEntity getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
    }
}
