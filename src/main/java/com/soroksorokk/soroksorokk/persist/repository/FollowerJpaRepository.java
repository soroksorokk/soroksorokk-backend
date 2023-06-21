package com.soroksorokk.soroksorokk.persist.repository;

import com.soroksorokk.soroksorokk.persist.entities.FollowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowerJpaRepository extends JpaRepository<FollowerEntity, Long> {
}
