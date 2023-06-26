package com.soroksorokk.soroksorokk.category.repository;

import com.soroksorokk.soroksorokk.common.RepositoryTest;
import com.soroksorokk.soroksorokk.persist.entities.CategoryEntity;
import com.soroksorokk.soroksorokk.persist.repository.CategoryJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RepositoryTest
class DefaultCategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void createCategory() {
        CategoryEntity category = CategoryEntity.builder()
                .name("category")
                .build();

        CategoryEntity save = categoryRepository.createCategory(category);
        System.out.println(save.getId());System.out.println(save.getFeeds());System.out.println(save.getName());
    }

    @Test
    void existsByName() {
        String name = "category1";
        boolean beforeCreate = categoryRepository.existsByName(name);
        assertThat(beforeCreate).isFalse();

        CategoryEntity category = CategoryEntity.builder()
                .name(name)
                .build();

        categoryRepository.createCategory(category);
        boolean afterCreate = categoryRepository.existsByName(name);
        assertThat(afterCreate).isTrue();
    }
}