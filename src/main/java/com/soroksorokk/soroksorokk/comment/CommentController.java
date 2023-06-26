package com.soroksorokk.soroksorokk.comment;

import com.soroksorokk.soroksorokk.comment.dto.request.CreateCommentRequestDto;
import com.soroksorokk.soroksorokk.comment.dto.request.UpdateCommentRequestDto;
import com.soroksorokk.soroksorokk.comment.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RequestMapping("comments")
@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void createComment(CreateCommentRequestDto request,
                              @AuthenticationPrincipal UserDetails userDetails) {
        commentService.createComment(request, userDetails.getUsername());
    }

    @PutMapping("/{commentId}")
    public void updateComment(UpdateCommentRequestDto request, @PathVariable("commentId") Long commentId,
                              @AuthenticationPrincipal UserDetails userDetails) {
        commentService.updateComment(commentId, userDetails.getUsername(), request);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable("commentId") Long commentId,
                              @AuthenticationPrincipal UserDetails userDetails) {
        commentService.deleteCommentById(commentId, userDetails.getUsername());
    }
}
