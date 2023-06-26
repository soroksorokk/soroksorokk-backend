package com.soroksorokk.soroksorokk.persist.repository;

import com.soroksorokk.soroksorokk.comment.repository.CommentQueryRepository;
import com.soroksorokk.soroksorokk.persist.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentJpaRepository extends JpaRepository<CommentEntity, Long>, CommentQueryRepository {
}
