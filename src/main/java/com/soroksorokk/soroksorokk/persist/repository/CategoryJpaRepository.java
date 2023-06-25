package com.soroksorokk.soroksorokk.persist.repository;

import com.soroksorokk.soroksorokk.persist.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {
    boolean existsByName(String categoryName);
}
