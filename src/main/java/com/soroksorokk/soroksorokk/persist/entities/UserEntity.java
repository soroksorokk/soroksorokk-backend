package com.soroksorokk.soroksorokk.persist.entities;

import com.soroksorokk.soroksorokk.persist.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@OnDelete(action = OnDeleteAction.CASCADE)
@Entity(name = "users")
public class UserEntity extends BaseTimeEntity {
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

    @Builder
    public UserEntity(String nickname, String email, String password, String img) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.img = img;
        this.feeds = Collections.emptyList();
        this.comments = Collections.emptyList();
        this.replies = Collections.emptyList();
        this.bookmarks = Collections.emptyList();
        this.followers = Collections.emptyList();
        this.followings = Collections.emptyList();
        this.userTags = Collections.emptyList();
    }
}
