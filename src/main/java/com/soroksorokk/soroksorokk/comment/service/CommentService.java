package com.soroksorokk.soroksorokk.comment.service;

import com.soroksorokk.soroksorokk.comment.dto.request.CreateCommentRequestDto;
import com.soroksorokk.soroksorokk.comment.dto.request.UpdateCommentRequestDto;
import com.soroksorokk.soroksorokk.comment.dto.response.GetAllCommentsResponseDto;
import com.soroksorokk.soroksorokk.comment.exception.NotCommentWriterException;
import com.soroksorokk.soroksorokk.comment.repository.CommentRepository;
import com.soroksorokk.soroksorokk.feed.repository.FeedRepository;
import com.soroksorokk.soroksorokk.persist.entities.CommentEntity;
import com.soroksorokk.soroksorokk.persist.entities.FeedEntity;
import com.soroksorokk.soroksorokk.persist.entities.UserEntity;
import com.soroksorokk.soroksorokk.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final FeedRepository feedRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository,
                          FeedRepository feedRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.feedRepository = feedRepository;
    }

    public void createComment(CreateCommentRequestDto request, String email) {
        UserEntity dbUser = userRepository.findByEmail(email);
        FeedEntity dbFeed = feedRepository.getFeedById(request.getFeedId());
        commentRepository.createComment(CommentEntity.builder()
                .text(request.getComment())
                .user(dbUser)
                .feed(dbFeed)
                .build());
    }

    public void updateComment(Long id, String email, UpdateCommentRequestDto request) {
        CommentEntity dbComment = commentRepository.getCommentById(id);
        UserEntity dbUser = userRepository.findByEmail(email);

        if (!dbComment.validateWriter(dbUser.getId())) {
            throw new NotCommentWriterException();
        }

        dbComment.updateComment(request.getText());
    }

    public void deleteCommentById(Long id, String email) {
        UserEntity dbUser = userRepository.findByEmail(email);
        CommentEntity dbComment = commentRepository.getCommentById(id);

        if (!dbComment.validateWriter(dbUser.getId())) {
            throw new NotCommentWriterException();
        }

        commentRepository.deleteCommentById(id);
    }

    @Transactional(readOnly = true)
    public List<GetAllCommentsResponseDto> getAllComments(String email) {
        UserEntity dbUser = userRepository.findByEmail(email);

        List<CommentEntity> comments = commentRepository.getAllCommentsByUserId(dbUser.getId());

        return null;
    }
}
