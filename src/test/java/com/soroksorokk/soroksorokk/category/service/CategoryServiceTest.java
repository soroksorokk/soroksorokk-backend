package com.soroksorokk.soroksorokk.category.service;

import com.soroksorokk.soroksorokk.category.exception.DuplicatedCategoryNameException;
import com.soroksorokk.soroksorokk.category.repository.CategoryRepository;
import com.soroksorokk.soroksorokk.persist.entities.CategoryEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {
    @Mock
    CategoryRepository categoryRepository;

    @InjectMocks
    CategoryService categoryService;

    @Test
    void createCategory_success() {
        // given
        given(categoryRepository.existsByName(anyString())).willReturn(false);
        // when
        categoryService.createCategory("name");
        //then
        verify(categoryRepository).existsByName("name");
        verify(categoryRepository).createCategory(any(CategoryEntity.class));
    }

    @Test
    void createCategory_fail() {
        // given
        given(categoryRepository.existsByName(anyString())).willReturn(true);
        // when
        assertThatThrownBy(() -> categoryService.createCategory("name"))
                .isInstanceOf(DuplicatedCategoryNameException.class)
                .hasMessage(DuplicatedCategoryNameException.error.getMsg());

        //then
        verify(categoryRepository).existsByName("name");
    }
}