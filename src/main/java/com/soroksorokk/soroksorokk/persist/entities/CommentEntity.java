package com.soroksorokk.soroksorokk.persist.entities;

import com.soroksorokk.soroksorokk.comment.dto.request.UpdateCommentRequestDto;
import com.soroksorokk.soroksorokk.persist.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "comment")
public class CommentEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String text;

    @ManyToOne(optional = false)
    private UserEntity user;

    @ManyToOne(optional = false)
    private FeedEntity feed;

    @OneToMany(mappedBy = "comment")
    private List<CommentLikeEntity> likes;

    @Builder
    public CommentEntity(String text, UserEntity user, FeedEntity feed) {
        this.text = text;
        this.user = user;
        this.feed = feed;
    }

    public boolean validateWriter(long id) {
        return Objects.equals(this.getUser().getId(), id);
    }

    public void updateComment(String text) {
        this.text = text;
    }
}
