package com.soroksorokk.soroksorokk.comment.repository;

import com.soroksorokk.soroksorokk.persist.entities.CommentEntity;

import java.util.List;

public interface CommentQueryRepository {
    void deleteCommentById(Long id);

    List<CommentEntity> getAllCommentsByUserId(Long userId);

    void updateCommentById(Long id, CommentEntity newComment);
}
