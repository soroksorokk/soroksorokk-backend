package com.soroksorokk.soroksorokk.comment.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.soroksorokk.soroksorokk.persist.entities.CommentEntity;
import com.soroksorokk.soroksorokk.persist.entities.QCommentEntity;

import java.time.LocalDateTime;
import java.util.List;

public class CommentQueryRepositoryImpl implements CommentQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public CommentQueryRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public void deleteCommentById(Long id) {
        QCommentEntity comment = QCommentEntity.commentEntity;
        jpaQueryFactory.update(comment)
                .set(comment.deletedAt, LocalDateTime.now())
                .where(comment.id.eq(id))
                .execute();
    }

    @Override
    public List<CommentEntity> getAllCommentsByUserId(Long userId) {
        QCommentEntity comment = QCommentEntity.commentEntity;
        return jpaQueryFactory.select(comment)
                .from(comment)
                .where(comment.user.id.eq(userId))
                .fetch();
    }

    @Override
    public void updateCommentById(Long id, CommentEntity newComment) {
        QCommentEntity comment = QCommentEntity.commentEntity;
        jpaQueryFactory.update(comment)
                .set(comment, newComment)
                .where(comment.id.eq(id))
                .execute();
    }
}
