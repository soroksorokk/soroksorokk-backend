package com.soroksorokk.soroksorokk.category.repository;

import com.soroksorokk.soroksorokk.persist.entities.CategoryEntity;

import java.util.List;

public interface CategoryQueryRepository {

    boolean existsByName(String categoryName);

    CategoryEntity getCategoryById(Long id);

    List<CategoryEntity> getAllCategories();
}
