package com.soroksorokk.soroksorokk.comment.repository;

import com.soroksorokk.soroksorokk.persist.entities.CommentEntity;

import java.util.List;

public interface CommentRepository {
    List<CommentEntity> getAllCommentsByUserId(Long userId);
    void createComment(CommentEntity comment);
    void deleteCommentById(Long id);

    CommentEntity getCommentById(Long id);

    void updateComment(Long id, CommentEntity newComment);
}
