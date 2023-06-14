package com.soroksorokk.soroksorokk.persist.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class CommentEntity {
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
}
