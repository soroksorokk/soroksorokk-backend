package com.soroksorokk.soroksorokk.comment.repository;

import com.soroksorokk.soroksorokk.comment.exception.CommentNotFoundException;
import com.soroksorokk.soroksorokk.persist.entities.CommentEntity;
import com.soroksorokk.soroksorokk.persist.repository.CommentJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DefaultCommentRepository implements CommentRepository{
    private final CommentJpaRepository commentRepository;

    public DefaultCommentRepository(CommentJpaRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentEntity> getAllCommentsByUserId(Long userId) {
        return commentRepository.getAllCommentsByUserId(userId);
    }

    @Override
    public void createComment(CommentEntity comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteCommentById(Long id) {
        commentRepository.deleteCommentById(id);
    }

    @Override
    public CommentEntity getCommentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(CommentNotFoundException::new);
    }

    @Override
    public void updateComment(Long id, CommentEntity newComment) {
        commentRepository.updateCommentById(id, newComment);
    }
}
