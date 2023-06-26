package com.soroksorokk.soroksorokk.category.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.soroksorokk.soroksorokk.persist.entities.CategoryEntity;
import com.soroksorokk.soroksorokk.persist.entities.QCategoryEntity;

public class CategoryQueryRepositoryImpl implements CategoryQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public CategoryQueryRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public boolean existsByName(String categoryName) {
        QCategoryEntity category = QCategoryEntity.categoryEntity;
        CategoryEntity dbCategory = jpaQueryFactory.select(category)
                .from(category)
                .where(category.name.eq(categoryName))
                .fetchOne();

        return dbCategory != null;
    }

    @Override
    public CategoryEntity getCategoryById(Long id) {
        QCategoryEntity category = QCategoryEntity.categoryEntity;
        return jpaQueryFactory.select(category)
                .from(category)
                .where(category.id.eq(id))
                .fetchOne();
    }
}
