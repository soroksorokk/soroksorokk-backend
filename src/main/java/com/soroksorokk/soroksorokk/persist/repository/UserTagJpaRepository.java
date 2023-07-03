package com.soroksorokk.soroksorokk.persist.repository;

import com.soroksorokk.soroksorokk.persist.entities.UserTagEntity;
import com.soroksorokk.soroksorokk.userTag.repository.UserTagQueryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTagJpaRepository extends JpaRepository<UserTagEntity, Long>, UserTagQueryRepository {
}
