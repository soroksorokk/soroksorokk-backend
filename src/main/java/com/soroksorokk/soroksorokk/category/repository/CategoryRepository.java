package com.soroksorokk.soroksorokk.category.repository;

import com.soroksorokk.soroksorokk.persist.entities.CategoryEntity;

public interface CategoryRepository {
    CategoryEntity createCategory(CategoryEntity category);

    boolean existsByName(String categoryName);

    CategoryEntity getCategoryById(Long id);
}
