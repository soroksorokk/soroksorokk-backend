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
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false, unique = true)
    private String nickname;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column
    private String img;

    @OneToMany(mappedBy = "user")
    private List<FeedEntity> feeds;

    @OneToMany(mappedBy = "user")
    private List<CommentEntity> comments;

    @OneToMany(mappedBy = "user")
    private List<ReplyEntity> replies;

    @OneToMany(mappedBy = "user")
    private List<BookmarkEntity> bookmarks;

    @OneToMany(mappedBy = "user")
    private List<FollowerEntity> followers;

    @OneToMany(mappedBy = "user")
    private List<FollowingEntity> followings;

    @OneToMany(mappedBy = "user")
    private List<UserTagEntity> userTags;
}
